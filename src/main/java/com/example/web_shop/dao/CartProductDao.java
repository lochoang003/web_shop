package com.example.web_shop.dao;

import com.example.web_shop.model.CartProducts;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CartProductDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<CartProducts> getAll(){
        String queryStr = "SELECT cp FROM CartProducts cp";
        TypedQuery<CartProducts> query = entityManager.createQuery(queryStr, CartProducts.class);
        return query.getResultList();
    }
    public CartProducts findById(int id){
        return entityManager.find(CartProducts.class,id);
    }
    public void save(CartProducts cartProducts){
        entityManager.persist(cartProducts);
    }
    public void edit(CartProducts cartProducts){
        entityManager.merge(cartProducts);
    }
    public void delete(CartProducts cartProducts){
        entityManager.remove(cartProducts.getId());
    }
}
