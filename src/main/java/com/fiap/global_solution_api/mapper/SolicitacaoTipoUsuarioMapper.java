package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoRequestDTO;
import com.fiap.global_solution_api.dto.SolicitacaoVerificacaoResponseDTO;
import com.fiap.global_solution_api.model.SolicitacaoTipoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SolicitacaoTipoUsuarioMapper {

    SolicitacaoTipoUsuario toEntity(SolicitacaoVerificacaoRequestDTO dto);

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    SolicitacaoVerificacaoResponseDTO toResponseDTO(SolicitacaoTipoUsuario entity);
}
