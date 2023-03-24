package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Organization;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * маппер для {@link Organization} готовый DTO {@link OrganizationDTO}
 */
@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    Organization toEntity(OrganizationDTO organizationDTO);

    OrganizationDTO toDTO(Organization organization);

    Collection<Organization>  toEntiityList(Collection<OrganizationDTO> organizationDTOS);

    Collection<OrganizationDTO>  toDTOList(Collection<Organization> organizations);
}
