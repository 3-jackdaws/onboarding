package com.altir.onboarding.api.onboarding;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnrollmentPostDTO {

    // Todo check validations rules for all DTO (need to return code 400)
    @NotBlank
    private String organizationId;
    @NotBlank
    private String userId;
    @NotBlank
    private String code;
}
