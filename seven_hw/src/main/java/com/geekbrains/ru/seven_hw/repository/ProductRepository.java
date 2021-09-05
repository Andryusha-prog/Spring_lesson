package com.geekbrains.ru.seven_hw.repository;

import com.geekbrains.ru.seven_hw.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

}
