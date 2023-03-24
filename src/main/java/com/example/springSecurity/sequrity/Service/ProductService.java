package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.NotificationDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTOHistory;
import com.example.springSecurity.sequrity.Entity.Product;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

/** * Сервис товаров */

public interface ProductService {

    /**     Получить список товаров     */
    Collection<ProductDTO> getAllProduct(Categories categories);
    /**   Показать товар     */
    ProductDTO getProductById(int id);

    /**     * Обновляет товар     */
    ProductDTO updateProduct(int id, ProductDTO productDTO, Authentication authentication);
    /**     * Добавляем товар     */
    ProductDTO addProduct(ProductDTO productDTO,  Authentication authentication)  throws IOException;

    /**     * Удаляет товар     */
    void deleteProduct(int id, Authentication authentication);
    /**     Получить уведомление     */
    Collection<NotificationDTO> getNotification(int id,NotificationDTO notificationDTO);
    /**     * Добавляем уведомление     */
    void addNotification(int id,NotificationDTO notificationDTO)  throws IOException;
    /**    Купить товар     */
    void buyProduct(int id,ProductDTO productDTO,Authentication authentication)  ;

    /**   Получить историю товара     */
    Collection<ProductDTOHistory> getProductDTOHistoryById(int id,Authentication authentication);

    /** Возврат продукта    */
    void refundProduct(int id,Authentication authentication) ;

    /** Оставить отзыв  и оценку */
    ProductDTO toLeaveReviews(int id,Authentication authentication,String reviewsDTO,int estimationDTO );
    /** Написать уведомление */
    void writeNotification(NotificationDTO notificationDTO);




}
