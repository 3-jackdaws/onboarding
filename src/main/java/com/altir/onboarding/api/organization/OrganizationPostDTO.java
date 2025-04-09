package com.altir.onboarding.api.organization;

import com.altir.onboarding.model.enums.AccountType;
import com.altir.onboarding.model.enums.OrganizationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizationPostDTO {

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalEin;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private OrganizationStatus status;
}
