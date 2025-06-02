package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.AtualizarNomeRequestDTO;
import com.fiap.global_solution_api.dto.AtualizarSenhaRequestDTO;
import com.fiap.global_solution_api.dto.UsuarioRequestDTO;
import com.fiap.global_solution_api.dto.UsuarioResponseDTO;
import com.fiap.global_solution_api.mapper.UsuarioMapper;
import com.fiap.global_solution_api.model.Usuario;
import com.fiap.global_solution_api.repository.UsuarioRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UsuarioResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
    }

    public List<UsuarioResponseDTO> findByNome(String nome){
        return repository.findByNomeStartsWithIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO atualizarNome(Long id, AtualizarNomeRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
        usuario.setNome(dto.getNome());
        repository.save(usuario);
        return mapper.toResponseDTO(usuario);
    }

    public void atualizarSenha(Long id, AtualizarSenhaRequestDTO dto){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
        if (!passwordEncoder.matches(dto.getSenhaAntiga(), usuario.getSenha())) {
            throw new IllegalArgumentException("Senha antiga incorreta.");
        }
        usuario.setSenha(passwordEncoder.encode(dto.getSenhaNova()));
        repository.save(usuario);
    }


}
