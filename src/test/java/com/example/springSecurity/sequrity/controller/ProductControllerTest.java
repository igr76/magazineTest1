package com.example.springSecurity.sequrity.controller;

import com.example.springSecurity.sequrity.Controller.ProductController;
import com.example.springSecurity.sequrity.DTO.Categories;
import com.example.springSecurity.sequrity.DTO.ProductDTO;
import com.example.springSecurity.sequrity.Entity.Product;
import com.example.springSecurity.sequrity.Mapper.ProductMapper;
import com.example.springSecurity.sequrity.Repositories.ProductRepository;
import com.example.springSecurity.sequrity.Service.Impl.SequrityServise;
import com.example.springSecurity.sequrity.Service.ProductService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    ProductService productService;
    SequrityServise sequrityServise;
    ProductRepository productRepository;
    ProductMapper productMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
//        time = "23-02-2022 08:09:10";
//        price = 11;
//        title = "заголовок";
//        email = "dmitr@gmail.com";
//        propertiesJS = new JSONObject();
//        propertiesJS.put("price", price);
//        propertiesJS.put("title", title);
//        authenticationJS = new JSONObject();
//        authenticationJS.put("email", email);

    }

    //    @AfterEach
//    void clearAllTestData() {
////        price = null;
////        title = null;
////        email = null;
////        propertiesJS = null;
////        authenticationJS = null;
////        image = null;
////        authentication = null;
////        properties = null;
////    }
//    @Test
//    void getAllProduct() throws Exception {
//        String url = "/Products";
//
//        mockMvc.perform(get(url)
//                        .content(authenticationJS.toString())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    void getProductById() throws Exception {
//        String url = "/product/{id}";
//
//        mockMvc.perform(get(url)
//                        .content(authenticationJS.toString())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }

    @Test
    void updateProduct() throws Exception {
        int id = 1;
        String url = "/product/" + id;

        JSONObject CreateObject = new JSONObject();
        CreateObject.put("name", "mouse");
        CreateObject.put("organization", "GTR");
        CreateObject.put("description", "good");
        CreateObject.put("price", 99);
        CreateObject.put("quantity", 6);
        CreateObject.put("discount", 6);
        CreateObject.put("categories", Categories.ELECTRONICS);

        when(productRepository.findById(id)).thenReturn(Optional.of(gettProduct()));

        Product resultProduct = gettProduct();
        resultProduct.setName("mouse");
        resultProduct.setOrganization("GTR");
        resultProduct.setDescription("good");
        resultProduct.setPrice(99);
        resultProduct.setQuantity(6);
        resultProduct.setDiscount(6);
        resultProduct.setCategories(Categories.ELECTRONICS);

        when(productRepository.save(resultProduct)).thenReturn(resultProduct);
        when(sequrityServise.checkUserOrganization(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.patch(
                                url)
                        .content(CreateObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("mouse"))
                .andExpect(jsonPath("$.organization").value("GTR"))
                .andExpect(jsonPath("$.description").value("good"))
                .andExpect(jsonPath("$.price").value(99))
                .andExpect(jsonPath("$.quantity").value(6))
                .andExpect(jsonPath("$.discount").value(6));

    }
//    @Test
//    void addProduct() throws Exception {
//        String url = "/product";
//
//        when(productMapper.toEntity(any(ProductDTO.class))).thenReturn(gettProduct());
//        when(sequrityServise.checkUserOrganization(any())).thenReturn(true);
//        when(productRepository.findMaxID()).thenReturn(1);
//
//        mockMvc.perform(multipart(url, HttpMethod.POST)
//                        .file(properties)
//                        .file(authentication)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.title").value(title))
//                .andExpect(jsonPath("$.price").value(price))
//                .andExpect(status().isOk());
//    }
    private Product gettProduct () {
            Product product = new Product();
            product.setId(1);
            product.setName("TV");
            product.setOrganization("IBM");
            product.setDescription("television");
            product.setPrice(66666);
            product.setQuantity(5);
            product.setDiscount(15);
            product.setCategories(Categories.ELECTRONICS);
            ArrayList<String> entityList = new ArrayList<>();
            entityList.add(new String("jgbcfybt"));
            entityList.add(new String("jgbcfybt"));
            product.setReviews(entityList);
            product.setKeyword(entityList);
            ArrayList<Integer> intEntityList = new ArrayList<>();
            intEntityList.add(1111);
            intEntityList.add(2222);
            product.setSpecificstions(intEntityList);
            product.setEstimation(intEntityList);
            return product;


    }
}
