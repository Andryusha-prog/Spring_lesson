package com.geekbrains.ru.Spring_mvc_hw.Service.Impl;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;
import com.geekbrains.ru.Spring_mvc_hw.Repository.ProductRepository;
import com.geekbrains.ru.Spring_mvc_hw.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    private ProductService productService;

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "testTitle1", 10));
        products.add(new Product(2, "testTitle2", 20));
        products.add(new Product(3, "testTitle3", 30));

        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);

        Mockito.when(productRepository.getProductById(1))
                .thenReturn(Optional.of(new Product(1, "title", 20)));

        Mockito.when(productRepository.getProductById(-1))
                .thenReturn(Optional.empty());

        Mockito.when(productService.getAllProducts()).thenReturn(products);

    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "testTitle1", 10));
        products.add(new Product(2, "testTitle2", 20));
        products.add(new Product(3, "testTitle3", 30));

        assertEquals(productService.getAllProducts(), products);
    }

    @Test
    void getProductById() {
        assertEquals(productService.getProductById(1), Optional.of(new Product(1, "title", 20)));
        assertEquals(productService.getProductById(-1), Optional.empty());
    }

}