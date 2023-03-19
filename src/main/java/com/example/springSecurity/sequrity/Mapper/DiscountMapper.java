package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.DiscountDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.Entity.Discount;
import com.example.springSecurity.sequrity.Entity.Product;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * маппер дляготовый DTO
 */
@Mapper(componentModel = "spring")
public interface DiscountMapper {
    Discount toEntity(DiscountDTO discountDTO);

    DiscountDTO toDTO(Discount discount);
    Collection<DiscountDTO> toDTOList(Collection<Discount> discounts);
}
