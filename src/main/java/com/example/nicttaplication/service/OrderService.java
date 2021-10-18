package com.example.nicttaplication.service;

import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(Long id){
        return repository.getById(id);


    }

    public List<Order> findAll(){
        return repository.findAll();

    }

    public void  save(Order order){
        repository.save(order);
    }

    public void  deleteOrder(long id){
        repository.deleteById(id);

    }

}
