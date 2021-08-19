package com.geekbrains.ru.Spring_mvc_hw.Service.Impl;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;
import com.geekbrains.ru.Spring_mvc_hw.Repository.ProductRepository;
import com.geekbrains.ru.Spring_mvc_hw.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void addNewProduct(int id, String title, double price) {
        productRepository.addNewProduct(id, title, price);
    }
}
