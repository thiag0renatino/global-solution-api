package com.fiap.global_solution_api.mapper;

import com.fiap.global_solution_api.dto.MensagemRequestDTO;
import com.fiap.global_solution_api.dto.MensagemResponseDTO;
import com.fiap.global_solution_api.model.Mensagem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MensagemMapper {

    @Mapping(source = "idOrigem", target = "origem.idDispositivo")
    @Mapping(source = "idDestino", target = "destino.idDispositivo")
    Mensagem toEntity(MensagemRequestDTO dto);

    MensagemResponseDTO toResponseDTO(Mensagem entity);
}
