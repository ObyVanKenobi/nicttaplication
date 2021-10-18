package com.example.nicttaplication.repository;

import com.example.nicttaplication.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
