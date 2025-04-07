package com.altir.onboarding.service;

import com.altir.onboarding.entity.OrganizationEntity;

import java.util.List;

public interface OrganizationService {

    List<OrganizationEntity> getAllOrganizations();

    OrganizationEntity createOrganization(OrganizationEntity organizationEntity);

    void deleteOrganization(String id);
}
