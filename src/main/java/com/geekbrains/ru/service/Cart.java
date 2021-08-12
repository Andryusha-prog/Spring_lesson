package com.geekbrains.ru.service;

public interface Cart {
    boolean addProductById(int id);
    boolean removeProductById(int id);
}
