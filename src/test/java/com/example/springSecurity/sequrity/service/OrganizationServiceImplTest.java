package com.example.springSecurity.sequrity.service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.OrganizationDTO;
import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Organization;
import com.example.springSecurity.sequrity.Mapper.OrganizationMapper;
import com.example.springSecurity.sequrity.Repositories.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
/**
 * Юнит тесты для сервиса
 */
@ExtendWith(MockitoExtension.class)
public class OrganizationServiceImplTest {
//    @Mock
//    OrganizationMapper organizationMapper;
//    @Mock
//    OrganizationRepository organizationRepository;
//
//    @Test
//    void getProductById() {
//        LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
//        Discount discount = new Discount( Role.USER,1,    date);
////        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
////                654,67,null,null,null,null,
////                null,null);
////        when(discountRepository.findAll()).thenReturn();
////        assertThat(productService.getProductById(1)).isEqualTo(productDTO1);
////        verify(productRepository, times(1)).findAllById(any());
//    }
//    @Test
//    void addDiscoun() {
//        Organization organization = new Organization( "Cberbank","Sber","666",null,true);
//        OrganizationDTO organizationDTO = new OrganizationDTO("Cberbank","Sber","666",null,true);
//        when(organizationMapper.toEntity(any())).thenReturn(organization);
//        when(organizationMapper.toDTO(any())).thenReturn((organizationDTO));
//        assertThat(organizationRepository.save(any())).isEqualTo(organization);
//        verify(organizationRepository, times(1)).findAllById(any());
//    }
//    @Test
//    void updateProduct() {
//        Organization organization = new Organization( "Cberbank","Sber","666",null,true);
//        OrganizationDTO organizationDTO = new OrganizationDTO("Cberbank","Sber","666",null,true);
//        when(organizationRepository.findById(any())).thenReturn(Optional.of(organization));
//        when(organizationMapper.toDTO(any())).thenReturn((organizationDTO));
//        assertThat(organizationRepository.save(any())).isEqualTo(organization);
//        verify(organizationRepository, times(1)).findAllById(any());
//    }
}
