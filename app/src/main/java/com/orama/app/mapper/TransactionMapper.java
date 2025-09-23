package com.orama.app.mapper;

import com.orama.app.dto.transaction.TransactionRequestDTO;
import com.orama.app.dto.transaction.TransactionResponseDTO;
import com.orama.app.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "client", ignore = true)
  @Mapping(target = "category", source = "category")
  Transaction toEntity(TransactionRequestDTO dto);

  @Mapping(target = "category", source = "category")
  TransactionResponseDTO toResponse(Transaction transaction);
}
