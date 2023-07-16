package com.example.web_shop.dao;

import com.example.web_shop.model.Carts;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CartsDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Carts> getAll(){
        String queryStr = "SELECT c FROM Carts c ";
        TypedQuery<Carts> query = entityManager.createQuery(queryStr, Carts.class);
        return query.getResultList();
    }
    public Carts findById(int id){
        return entityManager.find(Carts.class,id);
    }
    public void save(Carts carts){
        entityManager.persist(carts);
    }
    public void edit(Carts carts){
        entityManager.merge(carts);
    }
    public void delete(Carts carts){
        entityManager.remove(carts.getId());
    }
}
