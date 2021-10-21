package com.example.nicttaplication.service;

import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;



@SpringBootTest
class ProductServiceTest {

    @Autowired
    private   ProductService productService;
    @MockBean
    private ProductRepository productRepository;


    @Test
    void save() {
        Product product = new Product("product",500.00);
        boolean b = productService.save(product);
        Assert.isTrue(b,"product save error");
    }

}