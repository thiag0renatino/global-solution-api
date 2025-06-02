package com.fiap.global_solution_api.controller;

import com.fiap.global_solution_api.dto.MensagemRequestDTO;
import com.fiap.global_solution_api.dto.MensagemResponseDTO;
import com.fiap.global_solution_api.infra.security.SecurityConfigurations;
import com.fiap.global_solution_api.service.MensagemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class MensagemController {

    @Autowired
    private MensagemService service;

    @GetMapping
    public ResponseEntity<List<MensagemResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<MensagemResponseDTO>> findAllPageable(Pageable pageable) {
        return ResponseEntity.ok(service.findAllPageable(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensagemResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/offline")
    public ResponseEntity<List<MensagemResponseDTO>> findByOrigemIdAndSincronizado(@RequestParam Long idOrigem){
        return ResponseEntity.ok(service.findByOrigemIdAndSincronizado(idOrigem));
    }

    @PutMapping("/{id}/marcar-sincronizada")
    public ResponseEntity<Void> marcarMensagemSincronizada(@PathVariable Long id){
        service.marcarMensagemSincronizada(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MensagemResponseDTO> insert(@RequestBody @Valid MensagemRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
