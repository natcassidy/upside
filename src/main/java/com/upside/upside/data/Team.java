package com.upside.upside.data;

import com.upside.upside.service.dto.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "teams")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Team {
    @Id
    Long id;

    @Column(name = "team_name")
    String teamName;

    @Column(name = "score")
    Integer score;

    @Column(name = "created_at")
    LocalDate createdAt;

    @Column(name = "modified_at")
    LocalDate modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
