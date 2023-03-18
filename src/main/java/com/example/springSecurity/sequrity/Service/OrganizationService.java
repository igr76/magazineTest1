package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Collection;

public interface OrganizationService {
    /**
     * Возвращает комментарий
     *
     */
    Collection<OrganizationDTO> getOrganization();
    /**
     * Добавляем новое объявление
     *
     * @return возвращает созданное объявление
     */
    OrganizationDTO addOrganization(OrganizationDTO organizationDTO)
            throws IOException;
    /**
     * Обновляет объявление
     *
     * @param id - идентификатор объявления
     * @return - обнволенный комментарий
     */
    OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO, Authentication authentication);

}
