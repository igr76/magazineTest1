package com.example.springSecurity.sequrity.controller;

import com.example.springSecurity.sequrity.Controller.ProductController;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
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
//        propertiesNonValidJS = new JSONObject();
//        propertiesNonValidJS.put("title", title);
//        propertiesNonValidJS.put("price", price - 100);
//        commentDTO = new JSONObject();
//        commentDTO.put("author", ONE);
//        commentDTO.put("createdAt", time);
//        commentDTO.put("pk", ONE);
//        commentDTO.put("text", title);
//        commentDTONonValid = new JSONObject();
//        commentDTONonValid.put("author", ONE);
//        commentDTONonValid.put("createdAt", time);
//        commentDTONonValid.put("pk", ONE - 100);
//        commentDTONonValid.put("text", title);
//    }
    @AfterEach
    void clearAllTestData() {
//        price = null;
//        title = null;
//        email = null;
//        propertiesJS = null;
//        authenticationJS = null;
//        image = null;
//        authentication = null;
//        properties = null;
//    }
    @Test
    void updateComments() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.patch(
                                url)
                        .content(productObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value(1))
                .andExpect(jsonPath("$.createdAt").value("23-02-2022 08:09:10"))
                .andExpect(jsonPath("$.pk").value(2))
                .andExpect(jsonPath("$.text").value("text"));
    }
}
