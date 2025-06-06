package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.LocalizacaoRequestDTO;
import com.fiap.global_solution_api.dto.LocalizacaoResponseDTO;
import com.fiap.global_solution_api.mapper.LocalizacaoMapper;
import com.fiap.global_solution_api.model.Dispositivo;
import com.fiap.global_solution_api.model.Localizacao;
import com.fiap.global_solution_api.repository.DispositivoRepository;
import com.fiap.global_solution_api.repository.LocalizacaoRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repository;

    @Autowired
    private LocalizacaoMapper mapper;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<LocalizacaoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public LocalizacaoResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada: " + id));
    }

    public LocalizacaoResponseDTO insert(LocalizacaoRequestDTO dto) {
        Localizacao localizacao = mapper.toEntity(dto);

        Dispositivo dispositivo = dispositivoRepository.findById(dto.getIdDispositivo())
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado: " + dto.getIdDispositivo()));
        localizacao.setDispositivo(dispositivo);

        return mapper.toResponseDTO(repository.save(localizacao));
    }

    public LocalizacaoResponseDTO update(Long id, LocalizacaoRequestDTO dto) {
        Localizacao localizacaoExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada: " + id));

        localizacaoExist.setLatitude(dto.getLatitude());
        localizacaoExist.setLongitude(dto.getLongitude());
        localizacaoExist.setDataCaptura(dto.getDataCaptura());
        localizacaoExist.setDispositivo(dispositivoRepository.findById(dto.getIdDispositivo())
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado: " + dto.getIdDispositivo())));

        Localizacao localizacaoAtt = repository.save(localizacaoExist);
        return mapper.toResponseDTO(localizacaoAtt);
    }

    public void delete(Long id) {
        Localizacao localizacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada: " + id));
        repository.delete(localizacao);
    }
}
