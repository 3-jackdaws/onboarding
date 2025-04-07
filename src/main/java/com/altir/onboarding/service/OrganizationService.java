package com.altir.onboarding.service;

import com.altir.onboarding.entity.OrganizationEntity;
import com.altir.onboarding.model.Organization;
import com.altir.onboarding.model.User;

import java.util.List;

public interface OrganizationService {

    Organization getOrganizationById(String id);

    List<Organization> getOrganizations(String accountName, String federalEin);

    Organization createOrganization(Organization organization);

    void deleteOrganization(String id);

    Organization patchOrganization(String id, Organization organization);
}
