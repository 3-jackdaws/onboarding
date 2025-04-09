package com.altir.onboarding.api.organization;

import com.altir.onboarding.model.enums.AccountType;
import com.altir.onboarding.model.enums.OrganizationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrganizationDTO {

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalEin;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private OrganizationStatus organizationName;

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
}
