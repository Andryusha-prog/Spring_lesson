package com.geekbrains.ru.Spring_mvc_hw.Service;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(int id);
    void addNewProduct(int id, String title, double price);
}
