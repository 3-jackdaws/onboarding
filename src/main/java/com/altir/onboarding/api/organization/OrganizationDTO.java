package com.altir.onboarding.api.organization;

import com.altir.onboarding.api.user.UserPostDTO;
import com.altir.onboarding.entity.AccountType;
import com.altir.onboarding.entity.OrganizationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OrganizationDTO {

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalName;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private OrganizationStatus organizationName;
    @NotBlank
    private List<UserPostDTO> users;
}
