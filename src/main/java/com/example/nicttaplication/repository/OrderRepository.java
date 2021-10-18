package com.example.nicttaplication.repository;

import com.example.nicttaplication.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
