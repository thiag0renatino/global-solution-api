package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoRequestDTO;
import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoResponseDTO;
import com.fiap.global_solution_api.infra.security.SecurityConfigurations;
import com.fiap.global_solution_api.service.SolicitacaoTipoUsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{idUsuario}/solicitacoes-verificacao")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class SolicitacaoTipoUsuarioController {

    @Autowired
    private SolicitacaoTipoUsuarioService service;

    @GetMapping
    public ResponseEntity<List<SolicitacaoVerificacaoResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<SolicitacaoVerificacaoResponseDTO> solicitarVerificacao(@PathVariable Long idUsuario, @RequestBody @Valid SolicitacaoVerificacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarSolicitacao(idUsuario, dto));
    }

}
