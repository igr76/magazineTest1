package com.example.springSecurity.sequrity.Service.Impl;

import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Organization;
import com.example.springSecurity.sequrity.Mapper.OrganizationMapper;
import com.example.springSecurity.sequrity.Repositories.OrganizationRepository;
import com.example.springSecurity.sequrity.Service.OrganizationService;
import com.example.springSecurity.sequrity.exeption.AgentInitializationException;
import com.example.springSecurity.sequrity.exeption.ElemNotFound;
import com.example.springSecurity.sequrity.loger.FormLogInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collection;
/** * Сервис товаров */
@AllArgsConstructor
@Service
@Slf4j
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationMapper organizationMapper;
    private OrganizationRepository organizationRepository;
    private SequrityServise sequrityServise;

    /**     Получить список организаций     */
    @Override
    public Collection<OrganizationDTO> getOrganization() {
        log.info(FormLogInfo.getInfo());
        return organizationMapper.toDTOList(organizationRepository.findAll());
    }
    /**  Добавляем организацию     */

    @Override
    public OrganizationDTO addOrganization(OrganizationDTO organizationDTO, Authentication authentication) throws AgentInitializationException {
        log.info(FormLogInfo.getInfo());
        Organization organization1 = organizationRepository.findByName(organizationDTO.getName());
        if (organization1.getName() == organizationDTO.getName() || organizationDTO.isStatus()
                || !sequrityServise.isAdmin(authentication)) { throw new AgentInitializationException("У вас нет прав доступа");
        }
        Organization organization = organizationRepository.save(organizationMapper.toEntity(organizationDTO));
        return organizationMapper.toDTO(organization);
    }
    /**     Изменить организацию     */
    @Override
    public OrganizationDTO updateOrganization(int id, OrganizationDTO organizationDTO, Authentication authentication) {
        log.info(FormLogInfo.getInfo());
        Organization organization = organizationRepository.findById(id).orElseThrow(ElemNotFound::new);
        organizationRepository.save(organization);
        return organizationMapper.toDTO(organization);
    }


}
