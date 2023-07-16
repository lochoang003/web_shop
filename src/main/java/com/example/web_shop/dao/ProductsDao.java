package com.example.web_shop.dao;

import com.example.web_shop.model.Products;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProductsDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Products> getAll(){
        String queryStr = "SELECT p FROM Products p";
        TypedQuery<Products> query  = entityManager.createQuery(queryStr, Products.class);
        return  query.getResultList();
    }
    public Products findById(int id){
        return entityManager.find(Products.class, id);
    }
    public void save(Products product){
        entityManager.persist(product);

    }

    public void edit(Products product){
        entityManager.merge(product);
    }

    public void delete(Products product){
        entityManager.remove(product.getId());
    }


}
