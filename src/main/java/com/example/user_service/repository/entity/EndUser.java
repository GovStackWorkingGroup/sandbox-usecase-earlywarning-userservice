package com.example.user_service.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "end_user_table")
public class EndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end_user_id_seq")
    @SequenceGenerator(name = "end_user_id_seq", allocationSize = 1)
    private Long id;
    private UUID endUserUUID;
    private String fullName;
    private String email;
    private String contactPhone;
    private int countryId;
    private int defaultLanguageId;
    private int defaultCommunicationChannelId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID createdBy;
    private UUID updatedBy;

}
