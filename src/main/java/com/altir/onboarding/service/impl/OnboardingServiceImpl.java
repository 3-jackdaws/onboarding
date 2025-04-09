package com.altir.onboarding.service.impl;

import com.altir.onboarding.mapper.OnboardingMapper;
import com.altir.onboarding.model.Details;
import com.altir.onboarding.model.Onboarding;
import com.altir.onboarding.model.Organization;
import com.altir.onboarding.model.User;
import com.altir.onboarding.service.OnboardingService;
import com.altir.onboarding.service.OrganizationService;
import com.altir.onboarding.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OnboardingServiceImpl implements OnboardingService {

    private UserService userService;
    private OrganizationService organizationService;
    private OnboardingMapper onboardingMapper;

    @Override
    @Transactional // Todo check transactions for mongoDB
    public Details onboardingCreate(Onboarding onboarding) {

        // Todo add default values for user and organization model(status, role...)
        Organization organization = organizationService.createOrganization(onboardingMapper.toOrganizationFromOnboarding(onboarding));
        String organizationId = organization.getId();

        User userFromOnboarding = onboardingMapper.toUserFromOnboarding(onboarding);
        userFromOnboarding.setOrganizationId(organizationId);
        User user = userService.createUser(userFromOnboarding);

        Details details = new Details();
        details.setUserId(user.getId());
        details.setOrganizationId(organizationId);
        details.setNeedCode(true);

        return details;
    }
}
