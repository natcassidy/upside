package com.upside.upside.service;

import com.upside.upside.service.dto.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team convertToDto(com.upside.upside.data.Team team);
    com.upside.upside.data.Team convertToEntity(Team team);
}
