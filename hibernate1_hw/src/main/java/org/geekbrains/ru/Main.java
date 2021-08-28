package org.geekbrains.ru;

import org.flywaydb.core.Flyway;
import org.geekbrains.ru.product.Product;
import org.geekbrains.ru.product.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;

public class Main {

    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        /* Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/first-app", "postgres", "postgrespass").load();
        flyway.migrate();
    */
        try{
            init();
            ProductDao productDao = new ProductDao(sessionFactory);
            System.out.println(productDao.findById(2L));
            System.out.println(productDao.findAll());
            System.out.println(productDao.saveOrUpdate(new Product("title303", 3040)));
            //productDao.deleteById(1L);
            //System.out.println(productDao.findAll());

        } finally {
            shutdown();
        }

    }

    private static void init(){
        sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
    }

    private static void shutdown(){
        sessionFactory.close();
    }

    private static void test(){
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product1 = new Product("title 1", 100);
            Product product2 = new Product("title 2", 200);
            session.save(product1);
            session.save(product2);
            session.getTransaction().commit();
        }
    }
}
