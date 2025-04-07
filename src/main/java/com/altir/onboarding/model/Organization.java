package com.altir.onboarding.model;

import com.altir.onboarding.api.user.UserPostDTO;
import com.altir.onboarding.entity.AccountType;
import com.altir.onboarding.entity.OrganizationStatus;
import lombok.Data;

import java.util.List;

@Data
public class Organization {

    private String accountName;
    private String federalName;
    private AccountType accountType;
    private OrganizationStatus organizationName;
    private List<UserPostDTO> users;
}
