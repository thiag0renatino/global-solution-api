package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.DispositivoRequestDTO;
import com.fiap.global_solution_api.dto.DispositivoResponseDTO;
import com.fiap.global_solution_api.mapper.DispositivoMapper;
import com.fiap.global_solution_api.model.Dispositivo;
import com.fiap.global_solution_api.repository.DispositivoRepository;
import com.fiap.global_solution_api.repository.UsuarioRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DispositivoMapper mapper;

    public List<DispositivoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public DispositivoResponseDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado: " + id));
    }

    public DispositivoResponseDTO insert(DispositivoRequestDTO dto){
        if (repository.existsByUuid(dto.getUuid())) {
            throw new IllegalArgumentException("UUID já cadastrado: " + dto.getUuid());
        }
        Dispositivo dispositivo = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(dispositivo));
    }

    public DispositivoResponseDTO update(Long id, DispositivoRequestDTO dto) {
        Dispositivo dispositivoExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado: " + id));

        if (!dispositivoExist.getUuid().equals(dto.getUuid()) &&
                repository.existsByUuid(dto.getUuid())) {
            throw new IllegalArgumentException("UUID já cadastrado: " + dto.getUuid());
        }

        dispositivoExist.setUuid(dto.getUuid());
        dispositivoExist.setUsuario(usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + dto.getIdUsuario())));

        return mapper.toResponseDTO(repository.save(dispositivoExist));
    }

    public void delete(Long id) {
        Dispositivo dispositivo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado: " + id));
        repository.delete(dispositivo);
    }

}
