package org.geekbrains.ru.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

public class ProductDao {

    public SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product findById(Long id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.createQuery("SELECT s FROM Product s WHERE s.id = :id", Product.class).setParameter("id", id).getSingleResult();
            session.getTransaction().commit();

            return product;
        }
    }

    public List<Product> findAll(){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("SELECT s FROM Product s", Product.class).getResultList();
            session.getTransaction().commit();

            return productList;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public Product saveOrUpdate(Product product){//Не знаю, такая ли была идея по заданию, но как понял так и сделал...
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<Product> result = session.createQuery("SELECT s FROM Product s WHERE s.title = :title", Product.class).setParameter("title", product.getTitle()).getResultList();
            if(result.size() != 0) {
                Product updProduct = session.get(Product.class, result.get(0).getId());
                updProduct.setPrice(product.getPrice());
            }
            else {
                session.save(product);
            }
            session.getTransaction().commit();
        }
        return product;
    }

}
