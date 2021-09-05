package com.geekbrains.ru.seven_hw.service;


import com.geekbrains.ru.seven_hw.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(long id);

    Product save(Product product);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

}
