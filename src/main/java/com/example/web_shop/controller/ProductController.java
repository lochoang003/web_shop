package com.example.web_shop.controller;

import com.example.web_shop.dao.ProductsDao;
import com.example.web_shop.model.Products;
import com.example.web_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductsService productsService;
    @GetMapping()
    public String showCreateProduct(Model model){
        model.addAttribute("product",new Products());
        return "/products/create";
    }
    @PostMapping()
    public String createProduct(Products product , @RequestParam MultipartFile imgFile){
        productsService.save(product,imgFile);
        return "redirect:/home";
    }
}
