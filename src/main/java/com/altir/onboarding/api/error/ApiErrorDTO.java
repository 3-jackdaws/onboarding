package com.altir.onboarding.api.error;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiErrorDTO {

    private String message;
    private String error;

    public ApiErrorDTO error(String error) {
        this.error = error;
        return this;
    }

    public ApiErrorDTO message(String message) {
        this.message = message;
        return this;
    }
}
