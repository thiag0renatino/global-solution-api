package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.LocalizacaoRequestDTO;
import com.fiap.global_solution_api.dto.LocalizacaoResponseDTO;
import com.fiap.global_solution_api.model.Localizacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocalizacaoMapper {

    @Mapping(source = "idDispositivo", target = "dispositivo.idDispositivo")
    Localizacao toEntity(LocalizacaoRequestDTO dto);

    LocalizacaoResponseDTO toResponseDTO(Localizacao entity);
}
