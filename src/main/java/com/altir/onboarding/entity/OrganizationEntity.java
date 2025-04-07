package com.altir.onboarding.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class OrganizationEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalEin;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private OrganizationStatus status;

    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @LastModifiedBy
    private String updatedBy;
}
