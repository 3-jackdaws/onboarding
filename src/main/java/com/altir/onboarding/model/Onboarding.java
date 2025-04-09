package com.altir.onboarding.model;

import com.altir.onboarding.model.enums.AccountType;
import com.altir.onboarding.model.enums.LoginType;
import lombok.Data;

@Data
public class Onboarding {

    private String accountName;
    private String federalEin;
    private AccountType accountType;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LoginType loginType;
}
