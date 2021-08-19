package com.geekbrains.ru.Spring_mvc_hw.Controller;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;
import com.geekbrains.ru.Spring_mvc_hw.Service.ProductService;
import com.geekbrains.ru.Spring_mvc_hw.SpringMvcHwApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest extends SpringMvcHwApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(0, "title0", 0));
        products.add(new Product(1, "title1", 10));
        products.add(new Product(2, "title2", 20));
        products.add(new Product());
        Mockito.when(productService.getAllProducts())
                .thenReturn(products);

    }

    @Test
    void getProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(0, "title0", 0));
        products.add(new Product(1, "title1", 10));
        products.add(new Product(2, "title2", 20));
        products.add(new Product());

        System.out.println(products.toString());
        mockMvc.perform(MockMvcRequestBuilders.get("/product/getproduct"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("products", products));
    }
}