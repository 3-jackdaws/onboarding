package com.altir.onboarding.service.impl;

import com.altir.onboarding.config.OrganizationDefaultConfigurations;
import com.altir.onboarding.model.Organization;
import com.altir.onboarding.model.enums.OrganizationStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationNormalizationService {

    private final OrganizationDefaultConfigurations defaultConfigurations;

    public void normalize(Organization organization) {
        normalizeStatus(organization);
    }

    private void normalizeStatus(Organization organization) {
        if (organization.getStatus() == null) {
            organization.setStatus(OrganizationStatus.valueOf(defaultConfigurations.getStatus()));
        }
    }
}
