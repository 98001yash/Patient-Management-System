package com.company.authservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID id;

    @Column(unique = true, nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String role;
}
