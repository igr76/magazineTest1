package com.example.springSecurity.sequrity.Service;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface DiscountService {
    /**     Получить список скидок     */
    Collection<DiscountDTO> getDiscoun();
    /** Добавить скидку     */
    DiscountDTO addDiscoun(DiscountDTO discountDTO)
            throws IOException;
    /**     Изменить скидку     */
    DiscountDTO updateDiscoun(int id, DiscountDTO discountDTO);


}
