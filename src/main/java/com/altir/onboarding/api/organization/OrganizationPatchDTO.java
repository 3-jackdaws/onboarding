package com.altir.onboarding.api.organization;

import com.altir.onboarding.entity.AccountType;
import com.altir.onboarding.entity.OrganizationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrganizationPatchDTO {

    private String accountName;
    private String federalEin;
    private AccountType accountType;
    private OrganizationStatus status;
}
