package com.example.springSecurity.sequrity.service;

import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Mapper.ProductMapper;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.Service.Impl.SequrityServise;
import com.example.springSecurity.sequrity.Service.ProductService;
import com.example.springSecurity.sequrity.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import java.util.Collections;
import java.util.Optional;

/**
 * Юнит тесты для сервиса
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private UserService userService;
    @Mock
    ProductRepository productRepository;
    SequrityServise sequrityServise;
    ProductMapper productMapper;
    Product product;
    ProductDTO productDTO;
    @BeforeEach
    void init() {

    }

    @Test
    void getProductById() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product1));
        assertThat(productService.getProductById(1)).isEqualTo(productDTO1);
        verify(productRepository, times(1)).findAllById(any());
    }

    void updateProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.save(any())).thenReturn(Optional.of(product1));
        when(sequrityServise.checkAuthorEmailAndAdsId(anyInt(),any())).thenReturn(true);
        when(productMapper.toEntity(any())).thenReturn((product1));
        assertThat(productService.updateProduct(1,productDTO1,authentication)).isEqualTo(productDTO1);
        verify(productRepository, times(1)).findAllById(any());
    }
}
