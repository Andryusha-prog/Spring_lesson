package com.geekbrains.ru.Spring_mvc_hw.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String title;
    private double price;

    public Product() {

    }
}
