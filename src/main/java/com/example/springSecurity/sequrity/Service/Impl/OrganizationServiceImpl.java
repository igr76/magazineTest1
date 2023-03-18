package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Organization;
import com.example.springSecurity.sequrity.Mapper.OrganizationMapper;
import com.example.springSecurity.sequrity.Repositories.OrganizationRepository;
import com.example.springSecurity.sequrity.Service.OrganizationService;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Collection;

public class OrganizationServiceImpl implements OrganizationService {
    OrganizationMapper organizationMapper;
    OrganizationRepository organizationRepository;
    @Override
    public Collection<OrganizationDTO> getOrganization() {
        return organizationMapper.toDTOList(organizationRepository.findAll());
    }

    @Override
    public OrganizationDTO addOrganization(OrganizationDTO organizationDTO) throws IOException {
        Organization organization = organizationRepository.save(organizationMapper.toEntity(organizationDTO));
        return organizationMapper.toDTO(organization);
    }



    @Override
    public OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO, Authentication authentication) {
        Organization organization = organizationRepository.findById(id).orElseThrow(ElemNotFound::new);
        organizationRepository.save(organization);
        return organizationMapper.toDTO(organization);
    }
}
