package com.altir.onboarding.service.impl;

import com.altir.onboarding.entity.OrganizationEntity;
import com.altir.onboarding.repository.OrganizationRepository;
import com.altir.onboarding.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationEntity> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public OrganizationEntity createOrganization(OrganizationEntity organizationEntity) {
        return organizationRepository.save(organizationEntity);
    }

    @Override
    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }
}