package com.example.springSecurity.sequrity.service;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Entity.ProductHistory;
import com.example.springSecurity.sequrity.Mapper.DiscountMapper;
import com.example.springSecurity.sequrity.Repositories.DiscountRepository;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Юнит тесты для сервиса
 */
@ExtendWith(MockitoExtension.class)
public class DiscountServiceImplTest {
    DiscountRepository discountRepository;
    DiscountMapper discountMapper;


       @Test
    void getProductById() {
           LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
        Discount discount = new Discount( Role.USER,1,    date);
//        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
//                654,67,null,null,null,null,
//                null,null);
//        when(discountRepository.findAll()).thenReturn();
//        assertThat(productService.getProductById(1)).isEqualTo(productDTO1);
//        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void addDiscoun() {
        LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
        Discount discount = new Discount( Role.USER,1,    date);
        DiscountDTO discountDTO = new DiscountDTO(Role.USER,1,    date);
        when(discountMapper.toEntity(any())).thenReturn(discount);
        when(discountMapper.toDTO(any())).thenReturn((discountDTO));
        assertThat(discountRepository.save(any())).isEqualTo(discount);
        verify(discountRepository, times(1)).findAllById(any());
    }
    @Test
    void updateProduct() {
        LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
        Discount discount = new Discount( Role.USER,1,    date);
        DiscountDTO discountDTO = new DiscountDTO(Role.USER,1,    date);
        when(discountRepository.findById(any())).thenReturn(Optional.of(discount));
        when(discountMapper.toDTO(any())).thenReturn((discountDTO));
        assertThat(discountRepository.save(any())).isEqualTo(discount);
        verify(discountRepository, times(1)).findAllById(any());
    }
}
