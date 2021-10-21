package com.example.nicttaplication.service;

import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(Long id){
        return repository.getById(id);

    }

    public List<Product> findAll(){
        return repository.findAll();

    }

    public boolean save(Product product){
        if(product != null) {
            repository.save(product);
            return true;

        }
        return false;
    }

    public void  deleteOrder(long id){
        repository.deleteById(id);

    }
}
