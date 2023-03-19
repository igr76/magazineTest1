package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Collection;

public interface OrganizationService {
    /**     Получить список организаций     */
    Collection<OrganizationDTO> getOrganization();
    /**  Добавляем организацию     */
    OrganizationDTO addOrganization(OrganizationDTO organizationDTO)
            throws IOException;
    /**     Изменить организацию     */
    OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO, Authentication authentication);

}
