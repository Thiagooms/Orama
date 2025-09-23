package com.orama.app.mapper;

import com.orama.app.dto.goal.GoalRequestDTO;
import com.orama.app.dto.goal.GoalResponseDTO;
import com.orama.app.model.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoalMapper {

  GoalMapper INSTANCE = Mappers.getMapper(GoalMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "title", source = "title")
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  Goal toEntity(GoalRequestDTO dto);

  GoalResponseDTO toResponse(Goal goal);
}
