package com.upside.upside.data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    @Id
    Long id;

    @Column(name = "email")
    String email;

    @OneToOne(mappedBy = "user")
    Team team;
}
