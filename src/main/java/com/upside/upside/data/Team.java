package com.upside.upside.data;

import jakarta.persistence.*;
import lombok.*;

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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
