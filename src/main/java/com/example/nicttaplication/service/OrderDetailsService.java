package com.example.nicttaplication.service;

import com.example.nicttaplication.models.OrderDetails;
import com.example.nicttaplication.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository repository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository repository) {
        this.repository = repository;
    }

    public OrderDetails findById(Long id){
        return repository.getById(id);


    }

    public List<OrderDetails> findAll(){
        return repository.findAll();

    }

    public void  save(OrderDetails orderDetails){
        repository.save(orderDetails);
    }


    public void  deleteOrder(long id){
        repository.deleteById(id);

    }

}

