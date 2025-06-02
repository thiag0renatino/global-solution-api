package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.MensagemRequestDTO;
import com.fiap.global_solution_api.dto.MensagemResponseDTO;
import com.fiap.global_solution_api.mapper.MensagemMapper;
import com.fiap.global_solution_api.model.Mensagem;
import com.fiap.global_solution_api.repository.MensagemRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    @Autowired
    private MensagemMapper mapper;

    public List<MensagemResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public Page<MensagemResponseDTO> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponseDTO);
    }

    public MensagemResponseDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Mensagem não encontrada: " + id));
    }

    public List<MensagemResponseDTO> findByOrigemIdAndSincronizado(Long idOrigem){
        return repository.findByOrigemIdDispositivoAndSincronizado(idOrigem, "N")
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public MensagemResponseDTO insert(MensagemRequestDTO dto){
        Mensagem mensagem = mapper.toEntity(dto);
        mensagem.setDataEnvio(LocalDate.now());
        return mapper.toResponseDTO(repository.save(mensagem));
    }

    public void delete(Long id){
        Mensagem mensagem = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensagem não encontrada: " + id));
        repository.delete(mensagem);
    }
}
