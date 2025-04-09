package com.altir.onboarding.api.organization;

import com.altir.onboarding.model.enums.AccountType;
import com.altir.onboarding.model.enums.OrganizationStatus;
import lombok.Data;

@Data
public class OrganizationPatchDTO {

    private String accountName;
    private String federalEin;
    private AccountType accountType;
    private OrganizationStatus status;
}
