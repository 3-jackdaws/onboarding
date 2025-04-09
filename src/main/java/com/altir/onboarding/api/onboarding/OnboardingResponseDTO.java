package com.altir.onboarding.api.onboarding;

import lombok.Data;

@Data
public class OnboardingResponseDTO {

    private String organizationId;
    private String userId;
    private Boolean needCode;
}
