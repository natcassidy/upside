package com.upside.upside.service;

import com.upside.upside.service.dto.Team;
import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {
    Team sourceToDestination(com.upside.upside.data.Team team);
}
