package com.altir.onboarding.model;

import com.altir.onboarding.entity.AccountType;
import com.altir.onboarding.entity.OrganizationStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Organization {

    private String id;

    private String accountName;
    private String federalEin;
    private AccountType accountType;
    private OrganizationStatus status;

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
}
