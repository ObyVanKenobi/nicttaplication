package com.example.nicttaplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "enter your email address")
    @Size(min = 3, max = 50, message = "length must be more than 3 and less than 50 characters")
    @Email(message = "enter correct email")
    private String customerEmail;

    private String orderTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderDetails_id")
    private OrderDetails orderDetails;

    public Order(String customerEmail, OrderDetails orderDetails) {
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
    }
}