package com.geekbrains.ru.Spring_mvc_hw.Repository.Impl;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;
import com.geekbrains.ru.Spring_mvc_hw.Repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;


    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i, "title " + i, Math.random() * 1000));
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProductById(int id) {
        for (Product product: products) {
            if(product.getId() == id)
                return Optional.of(product);
        }
        return Optional.empty();
    }

    @Override
    public void addNewProduct(int id, String title, double price) {
        products.add(new Product(id, title, price));
    }
}
