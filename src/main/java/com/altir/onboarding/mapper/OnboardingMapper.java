package com.altir.onboarding.mapper;

import com.altir.onboarding.api.onboarding.OnboardingPostDTO;
import com.altir.onboarding.api.onboarding.OnboardingResponseDTO;
import com.altir.onboarding.model.Details;
import com.altir.onboarding.model.Onboarding;
import com.altir.onboarding.model.Organization;
import com.altir.onboarding.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OnboardingMapper {

    Onboarding toModel(OnboardingPostDTO postDTO);

    OnboardingResponseDTO toResponseDTO(Details details);

    User toUserFromOnboarding(Onboarding onboarding);

    Organization toOrganizationFromOnboarding(Onboarding onboarding);
}
