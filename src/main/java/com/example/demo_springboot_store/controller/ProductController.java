package com.example.demo_springboot_store.controller;

import com.example.demo_springboot_store.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String productsPage(Model model) {
        List<Product> products = Arrays.asList(
                new Product("Notebook", 9.99, "A ruled notebook"),
                new Product("Notebook", 9.99, "A ruled notebook"),
                new Product("Notebook", 9.99, "A ruled notebook")
        );

        model.addAttribute("products", products);
        return "products";
    }
}
