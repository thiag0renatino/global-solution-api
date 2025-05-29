package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.UsuarioRequestDTO;
import com.fiap.global_solution_api.dto.UsuarioResponseDTO;
import com.fiap.global_solution_api.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDTO dto);

    UsuarioResponseDTO toResponseDTO(Usuario entity);
}
