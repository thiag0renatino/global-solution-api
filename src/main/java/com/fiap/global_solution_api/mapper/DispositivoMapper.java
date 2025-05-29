package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.DispositivoRequestDTO;
import com.fiap.global_solution_api.dto.DispositivoResponseDTO;
import com.fiap.global_solution_api.model.Dispositivo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DispositivoMapper {

    @Mapping(source = "idUsuario", target = "usuario.idUsuario")
    Dispositivo toEntity(DispositivoRequestDTO dto);

    DispositivoResponseDTO toResponseDTO(Dispositivo entity);
}
