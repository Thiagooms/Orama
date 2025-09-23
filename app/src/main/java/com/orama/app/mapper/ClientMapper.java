package com.orama.app.mapper;

import com.orama.app.dto.clients.ClientRequestDTO;
import com.orama.app.dto.clients.ClientResponseDTO;
import com.orama.app.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "password", source = "password")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "balance", ignore = true)
  Client toEntity(ClientRequestDTO dto);

  @Mapping(target = "role", source = "role")
  ClientResponseDTO toResponse(Client client);
}
