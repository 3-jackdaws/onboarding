package com.altir.onboarding.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document
public class OrganizationEntity {

    @Id
    private String id;

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalEin;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private OrganizationStatus status;
    @NotBlank
    private List<String> userIds;

    private LocalDate createdDate;
    private String createdBy;
    private LocalDate updatedDate;
    private String updatedBy;
}
