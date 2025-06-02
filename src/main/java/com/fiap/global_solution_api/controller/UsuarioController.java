package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.AtualizarNomeRequestDTO;
import com.fiap.global_solution_api.dto.AtualizarSenhaRequestDTO;
import com.fiap.global_solution_api.dto.UsuarioResponseDTO;
import com.fiap.global_solution_api.infra.security.SecurityConfigurations;
import com.fiap.global_solution_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioResponseDTO>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PutMapping("/{id}/atualizar-nome")
    public ResponseEntity<UsuarioResponseDTO> atualizarNome(@PathVariable Long id, @RequestBody @Valid AtualizarNomeRequestDTO dto) {
        return ResponseEntity.ok(service.atualizarNome(id, dto));
    }

    @PutMapping("/{id}/atualizar-senha")
    public ResponseEntity<Void> atualizarSenha(@PathVariable Long id, @RequestBody @Valid AtualizarSenhaRequestDTO dto) {
        service.atualizarSenha(id, dto);
        return ResponseEntity.noContent().build();
    }


}
