package com.altir.onboarding.service.impl;

import com.altir.onboarding.exception.OrganizationNotFoundException;
import com.altir.onboarding.mapper.OrganizationMapper;
import com.altir.onboarding.mapper.OrganizationPatchMapper;
import com.altir.onboarding.model.Organization;
import com.altir.onboarding.repository.OrganizationRepository;
import com.altir.onboarding.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

@Slf4j
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private OrganizationMapper organizationMapper;
    private MongoTemplate mongoTemplate;
    private OrganizationPatchMapper organizationPatchMapper;

    @Override
    public Organization getOrganizationById(String id) {
        return organizationRepository.findById(id)
                .map(organizationMapper::toModel)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization with id: [%s] not found".formatted(id)));
    }

    @Override
    public List<Organization> getOrganizations(String accountName, String federalEin) {
        Criteria criteria = new Criteria();

        if (!StringUtils.isBlank(accountName)) {
            criteria.and("accountName").regex(accountName, "i");
        }
        if (!StringUtils.isBlank(federalEin)) {
            criteria.and("federalEin").regex(federalEin, "i");
        }

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria), sort(Sort.Direction.ASC, "id"));

        return mongoTemplate.aggregate(aggregation, "organizations", Organization.class).getMappedResults();
    }

    @Override
    public Organization createOrganization(Organization organization) {
        // Todo add check for existing organization via accountName and federalEin
        return organizationMapper.toModel(
                organizationRepository.save(
                        organizationMapper.toEntity(organization))
        );
    }

    @Override
    public Organization patchOrganization(String id, Organization updates) {
        Organization organization = getOrganizationById(id);
        organizationPatchMapper.copyNonNullFields(organization, updates);

        return organizationMapper.toModel(
                organizationRepository.save(
                        organizationMapper.toEntity(organization)));
    }

    @Override
    public void deleteOrganization(String id) {
        getOrganizationById(id);
        log.info("Deleting organization with id: [{}]...", id);
        organizationRepository.deleteById(id);
    }
}