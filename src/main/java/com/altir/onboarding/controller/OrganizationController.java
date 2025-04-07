package com.altir.onboarding.controller;

import com.altir.onboarding.entity.OrganizationEntity;
import com.altir.onboarding.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    public List<OrganizationEntity> getAllOrganization() {
        return organizationService.getAllOrganizations();
    }

    @PostMapping
    public OrganizationEntity createOrganization(@RequestBody OrganizationEntity organizationEntity) {
        return organizationService.createOrganization(organizationEntity);
    }

    @DeleteMapping
    public void deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
    }
}
