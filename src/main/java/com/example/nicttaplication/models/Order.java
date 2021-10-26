package com.example.nicttaplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String orderTime;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderDetails_id")
    private List<OrderDetails> orderDetails;


}