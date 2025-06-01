package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.DispositivoRequestDTO;
import com.fiap.global_solution_api.dto.DispositivoResponseDTO;
import com.fiap.global_solution_api.infra.security.SecurityConfigurations;
import com.fiap.global_solution_api.service.DispositivoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class DispositivoController {

    @Autowired
    private DispositivoService service;

    @GetMapping
    public ResponseEntity<List<DispositivoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispositivoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DispositivoResponseDTO> insert(@RequestBody @Valid DispositivoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoResponseDTO> update(@PathVariable Long id,
                                                         @RequestBody @Valid DispositivoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
