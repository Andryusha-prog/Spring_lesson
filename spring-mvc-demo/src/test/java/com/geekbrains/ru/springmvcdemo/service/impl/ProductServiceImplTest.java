package com.geekbrains.ru.springmvcdemo.service.impl;

import com.geekbrains.ru.springmvcdemo.SpringMvcDemoApplicationTest;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

class ProductServiceImplTest extends SpringMvcDemoApplicationTest {
/*
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
//        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
//        productService = new ProductServiceImpl(productRepository);

        Mockito.when(productRepository.findById(1L))
                .thenReturn(java.util.Optional.of(new Product(1L, "test", 20)));

        Mockito.when(productRepository.findById(2L))
                .thenReturn(java.util.Optional.empty());
    }

    @Test
    void findAll() {
        Product product = new Product(1L, "title", 20);

        Product savedProduct = productService.save(product);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    void findByIdExist() {
        Product expectedProduct = new Product(1L, "test", 20);

        Optional<Product> product = productService.findById(1L);

        Assertions.assertTrue(product.isPresent());
        Assertions.assertEquals(expectedProduct, product.get());
    }

    @Test
    void findByIdNotExist() {
        Optional<Product> product = productService.findById(2L);

        Assertions.assertFalse(product.isPresent());
    }*/
}