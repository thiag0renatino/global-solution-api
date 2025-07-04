package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.LocalizacaoRequestDTO;
import com.fiap.global_solution_api.dto.LocalizacaoResponseDTO;
import com.fiap.global_solution_api.infra.security.SecurityConfigurations;
import com.fiap.global_solution_api.service.LocalizacaoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService service;

    @GetMapping
    public ResponseEntity<List<LocalizacaoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LocalizacaoResponseDTO> insert(@RequestBody @Valid LocalizacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> update(@PathVariable Long id,
                                                         @RequestBody @Valid LocalizacaoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
