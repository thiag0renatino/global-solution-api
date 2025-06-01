package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.UsuarioRequestDTO;
import com.fiap.global_solution_api.dto.UsuarioResponseDTO;
import com.fiap.global_solution_api.mapper.UsuarioMapper;
import com.fiap.global_solution_api.model.Usuario;
import com.fiap.global_solution_api.repository.UsuarioRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

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

    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
        usuarioExistente.setNome(dto.getNome());
        usuarioExistente.setTipo(dto.getTipo());

        Usuario usuarioAtualizado = repository.save(usuarioExistente);
        return mapper.toResponseDTO(usuarioAtualizado);
    }
}
