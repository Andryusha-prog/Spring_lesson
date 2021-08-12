package com.geekbrains.ru.service.impl;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.repository.ProductRepository;
import com.geekbrains.ru.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productService;

    public ProductServiceImpl(ProductRepository productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productService.getProductById(id);
    }
}
