package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.PostRequestDTO;
import com.fiap.global_solution_api.dto.PostResponseDTO;
import com.fiap.global_solution_api.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

    @Mapping(source = "idUsuario", target = "usuario.idUsuario")
    Post toEntity(PostRequestDTO dto);

    PostResponseDTO toResponseDTO(Post entity);
}
