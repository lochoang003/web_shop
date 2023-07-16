package com.example.web_shop.service;

import com.example.web_shop.dao.ProductsDao;
import com.example.web_shop.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsDao productsDao;

    public void save(Products products, MultipartFile imgFile){
        productsDao.save(newProducts(products,imgFile));
    }
    public void  edit(Products products , MultipartFile imgFile){
        productsDao.edit(newProducts(products,imgFile));
    }
    public void delete(Products products){
        productsDao.delete(products);
    }

    public List<Products> getAll(){
        return productsDao.getAll();
    }

    private Products newProducts(Products products , MultipartFile imgFile){
        String nameFile = imgFile.getOriginalFilename();
        try {
            imgFile.transferTo(new File("C:\\Users\\Pc\\IdeaProjects\\WEB_Shop\\src\\main\\webapp\\img/" + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        products.setImg("/img/"+ nameFile);
        return products;
    }
}
