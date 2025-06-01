package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.UsuarioRequestDTO;
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

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
