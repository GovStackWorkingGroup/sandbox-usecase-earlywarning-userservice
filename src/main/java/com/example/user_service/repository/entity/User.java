package com.example.user_service.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", allocationSize = 1)
    private Long id;
    private UUID userUUID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactPhone;
    private int countryId;
}
