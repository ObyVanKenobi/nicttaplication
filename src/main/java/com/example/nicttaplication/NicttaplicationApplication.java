package com.example.nicttaplication;

import com.example.nicttaplication.service.OrderDetailsService;
import com.example.nicttaplication.service.OrderService;
import com.example.nicttaplication.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NicttaplicationApplication implements CommandLineRunner {

    final ProductService productService;
    final OrderDetailsService orderDetailsService;
    final OrderService orderService;

    public NicttaplicationApplication(ProductService productService, OrderDetailsService orderDetailsService, OrderService orderService) {
        this.productService = productService;
        this.orderDetailsService = orderDetailsService;
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(NicttaplicationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
