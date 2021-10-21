package com.example.nicttaplication;

import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NicttaplicationApplication implements CommandLineRunner {

    final ProductService productService;

    public NicttaplicationApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(NicttaplicationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Product milk = new Product("milk",100.00);
        productService.save(milk);
        Product cheese = new Product("cheese",200.00);
        productService.save(cheese);
        Product fish = new Product("fish",300.00);
        productService.save(fish);


    }
}
