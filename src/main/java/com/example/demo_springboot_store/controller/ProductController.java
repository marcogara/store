package com.example.demo_springboot_store.controller;

import com.example.demo_springboot_store.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product("Notebook", 9.99, "A ruled notebook."),
            new Product("Pen", 1.49, "A blue ink ballpoint pen."),
            new Product("Backpack", 29.99, "Lightweight school backpack.")
    ));

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/new")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products")
    public String submitProduct(@ModelAttribute Product product) {
        products.add(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        }
        return "redirect:/products";
    }
}
