package com.upside.upside.service.dto;

import com.upside.upside.data.User;
import lombok.Data;

@Data
public class Team {
    private Long id;
    private String teamName;
    private Integer score;
    private User user;
}
