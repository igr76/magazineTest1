package com.example.springSecurity.sequrity.Mapper;

import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.DTO.ProductDTOHistory;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Entity.ProductHistory;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);
     ProductDTO toDTO(Product product);
     ProductHistory toHistory(Product product);
     Product toProduct(ProductHistory productHistory);

     Collection<Product> toEntityList(Collection<ProductDTO> productDTOS);
     Collection<ProductDTO> toDTOList(Collection<Product> products);

     Collection<ProductDTOHistory> toDTOHistoryList(Collection<ProductHistory> productHistories);
}
