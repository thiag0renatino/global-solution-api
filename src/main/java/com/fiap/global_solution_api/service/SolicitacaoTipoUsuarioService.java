package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoRequestDTO;
import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoResponseDTO;
import com.fiap.global_solution_api.enuns.StatusVerificacao;
import com.fiap.global_solution_api.mapper.SolicitacaoTipoUsuarioMapper;
import com.fiap.global_solution_api.model.SolicitacaoTipoUsuario;
import com.fiap.global_solution_api.model.Usuario;
import com.fiap.global_solution_api.repository.SolicitacaoTipoUsuarioRepository;
import com.fiap.global_solution_api.repository.UsuarioRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitacaoTipoUsuarioService {

    @Autowired
    private SolicitacaoTipoUsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SolicitacaoTipoUsuarioMapper mapper;

    public List<SolicitacaoVerificacaoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public SolicitacaoVerificacaoResponseDTO criarSolicitacao(Long idUsuario, SolicitacaoVerificacaoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + idUsuario));

        SolicitacaoTipoUsuario solicitacao = mapper.toEntity(dto);
        solicitacao.setUsuario(usuario);
        solicitacao.setStatus(StatusVerificacao.PENDENTE);
        solicitacao.setDataSolicitacao(LocalDateTime.now());

        repository.save(solicitacao);
        return mapper.toResponseDTO(solicitacao);
    }

}
