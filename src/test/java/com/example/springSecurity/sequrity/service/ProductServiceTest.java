package com.example.springSecurity.sequrity.service;

import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.Role;
import com.example.springSecurity.sequrity.DTO.UserDTO;
import com.example.springSecurity.sequrity.Entity.Notification;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Entity.ProductHistory;
import com.example.springSecurity.sequrity.Entity.Users;
import com.example.springSecurity.sequrity.Mapper.NotificationMapper;
import com.example.springSecurity.sequrity.Mapper.ProductMapper;
import com.example.springSecurity.sequrity.Repositories.NotificationRepository;
import com.example.springSecurity.sequrity.Repositories.ProductHistoryRepository;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.Service.Impl.ProductServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Юнит тесты для сервиса
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private UserService userService;
    @Mock
    ProductRepository productRepository;
    SequrityServise sequrityServise;
    ProductMapper productMapper;
    NotificationRepository notificationRepository;
    NotificationMapper notificationMapper;
    ProductHistoryRepository productHistoryRepository;
    Product product;
    NotificationDTO notificationDTO;
    ProductDTO productDTO;
    UserDTO userDTO;
    Users users;
    ProductHistory productHistory;
    @BeforeEach
    void init() {
//        Product product1 = new Product(1,"igr","IBM","222",
//                654,67,null,null,null,null,
//                null,null);
//        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
//                654,67,null,null,null,null,
//                null,null);

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
    @Test
    void updateProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.save(any())).thenReturn(Optional.of(product1));
        when(sequrityServise.checkUserOrganization(any())).thenReturn(true);
        when(productMapper.toEntity(any())).thenReturn((product1));
        assertThat(productService.updateProduct(1,productDTO1,authentication)).isEqualTo(productDTO1);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void addProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.findMaxID()).thenReturn(0);
        when(sequrityServise.checkAuthorEmailAndAdsId(anyInt(),any())).thenReturn(true);
        when(productMapper.toEntity(any())).thenReturn((product1));
        assertThat(productService.updateProduct(1,productDTO1,authentication)).isEqualTo(productDTO1);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void deleteProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.findById(any())).thenReturn(Optional.of(product1));
        when(sequrityServise.checkAuthorEmailAndAdsId(anyInt(),any())).thenReturn(true);
        when(sequrityServise.checkIsAdmin(any())).thenReturn(true);
        when(sequrityServise.checkUserOrganization(any())).thenReturn(true);
        doNothing().when(productService).deleteProduct(anyInt(),authentication);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void addNotification() {
        LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
        NotificationDTO notificationDTO = new NotificationDTO("333", date, "333");
        Notification notification = new Notification("333", date, "333");
        when(notificationMapper.toEntity(any())).thenReturn(notification);
        assertThat(notificationRepository.save(any())).isEqualTo(notification);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void buyProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductHistory productHistory1 = new ProductHistory(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product1));
        when(sequrityServise.checkAuthorEmailAndAdsId(anyInt(),any())).thenReturn(true);
        when(sequrityServise.getUserByEmail(any()).getBalance()).thenReturn(55555);
        when(productMapper.toHistory(any())).thenReturn((productHistory1));
        when(productHistoryRepository.save(any(ProductHistory.class))).thenReturn(productHistory1);
        assertEquals(productService.updateProduct(1,productDTO1,authentication),productHistory1);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void refundProduct() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
//        Users user1 = new Users(1,"igr","user@gmail.com", "11111111", "94455",
//                 "path/to/image",   Role.USER,"IBM");
//        Authentication authentication = Mockito.mock(Authentication.class);
//        when(productRepository.findById(any())).thenReturn(Optional.of(product1));
//        when(sequrityServise.checkAuthorEmailAndAdsId(anyInt(),any())).thenReturn(true);
//        when(sequrityServise.isAdmin(any())).thenReturn(true);
//        when(sequrityServise.getUserByEmail(any())).thenReturn(user1);
//        doNothing().when(productService).deleteProduct(anyInt(),authentication);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void toLeaveReviews() {
        Product product1 = new Product(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        ProductDTO productDTO1 = new ProductDTO(1,"igr","IBM","222",
                654,67,null,null,null,null,
                null,null);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(productRepository.findById(any())).thenReturn(Optional.of(product1));
        when(sequrityServise.checkAuthorEmailAndAdsId(any(),authentication)).thenReturn(true);
        when(productMapper.toDTO(any())).thenReturn((productDTO1));
        assertThat(productService.toLeaveReviews(1,authentication,null,0)).isEqualTo(productDTO1);
        verify(productRepository, times(1)).findAllById(any());
    }
    @Test
    void writeNotification() {
        LocalDateTime date = LocalDateTime.parse("2007-12-03T10:15:30");
        NotificationDTO notificationDTO = new NotificationDTO("333", date, "333");
        Notification notification = new Notification("333", date, "333");
        when(notificationMapper.toEntity(any())).thenReturn(notification);
        assertThat(notificationRepository.save(any())).isEqualTo(notification);
        verify(productRepository, times(1)).findAllById(any());
    }
}
