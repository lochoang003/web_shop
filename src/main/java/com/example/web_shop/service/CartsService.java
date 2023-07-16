package com.example.web_shop.service;

import com.example.web_shop.dao.CartsDao;
import com.example.web_shop.model.Carts;
import com.example.web_shop.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CartsService {
    @Autowired
    CartsDao cartsDao;

    public List<Carts> getAll() {
        return cartsDao.getAll();
    }

    public void delete(Carts carts) {
        cartsDao.delete(carts);
    }

    public void edit(Carts carts ){
        cartsDao.edit(carts);
    }
    public void save(Carts carts){
        cartsDao.save(carts);
    }
}
