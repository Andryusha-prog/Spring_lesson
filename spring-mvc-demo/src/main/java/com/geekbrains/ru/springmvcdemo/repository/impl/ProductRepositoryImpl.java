package com.geekbrains.ru.springmvcdemo.repository.impl;


import com.geekbrains.ru.springmvcdemo.component.HibernateSessionFactoryManager;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final HibernateSessionFactoryManager factoryManager;

    @Override
    public List<Product> findAll() {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT s FROM Product s", Product.class).getResultList();
            System.out.println(products);
            session.getTransaction().commit();

            return products;
        }
    }

    @Override
    public Optional<Product> findById(long id) {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            Optional<Product> optional = Optional.ofNullable(session.get(Product.class, id));
            session.getTransaction().commit();

            return optional;
        }
    }

    @Override
    public Product save(Product product) {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();

            return product;
        }
    }
}
