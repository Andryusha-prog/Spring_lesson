package com.geekbrains.ru.service.impl;

import com.geekbrains.ru.domain.Product;
import com.geekbrains.ru.service.Cart;
import com.geekbrains.ru.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class CartImpl implements Cart {

    private final ProductService productService;
    private final List<Product> products;

    public CartImpl(ProductService productService) {
        this.productService = productService;
        this.products = new ArrayList<>();
    }

    @Override
    public boolean addProductById(int id) {
        Optional<Product> productOptional = productService.getProductById(id);
        if(productOptional.isPresent()) {
            products.add(productOptional.get());
            return true;
        }
        else return false;
    }

    @Override
    public boolean removeProductById(int id) {
        return products.removeIf(product -> product.getId() == id);
    }
}
