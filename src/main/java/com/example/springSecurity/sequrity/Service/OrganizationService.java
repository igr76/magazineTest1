package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.exeption.AgentInitializationException;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Collection;
/** * Сервис скидок */
public interface OrganizationService {
    /**     Получить список организаций     */
    Collection<OrganizationDTO> getOrganization();
    /**  Добавляем организацию     */
    OrganizationDTO addOrganization(OrganizationDTO organizationDTO, Authentication authentication)
            throws IOException, AgentInitializationException;
    /**     Изменить организацию     */
    OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO, Authentication authentication);


}
