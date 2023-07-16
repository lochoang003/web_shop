package com.example.web_shop.controller;

import com.example.web_shop.service.CartsService;
import com.example.web_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    ProductsService productsService;
    @Autowired
    CartsService cartsService;
    @GetMapping()
    public String showHome(Model model){
        model.addAttribute("products",productsService.getAll());
        return "shop";
    }
//    @GetMapping("/cart/{id}")
//    public String showCart( Model model,int id){
//        cartsService.save();
//        model.addAttribute("carts",)
//    }
}
