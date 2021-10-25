package com.example.nicttaplication.controllers;

import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String showAll(Model model) throws SQLException {
        List products = productService.findAll();
        model.addAttribute("products", products);

        return "show_all_products";
    }
}