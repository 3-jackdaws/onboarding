package com.altir.onboarding.api.onboarding;

import com.altir.onboarding.model.enums.AccountType;
import com.altir.onboarding.model.enums.LoginType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OnboardingPostDTO {

    @NotBlank
    private String accountName;
    @NotBlank
    private String federalEin;
    @NotBlank
    private AccountType accountType;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private LoginType loginType;
}
