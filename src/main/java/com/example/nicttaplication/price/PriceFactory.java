package com.example.nicttaplication.price;

import org.springframework.stereotype.Component;

@Component
public class PriceFactory {

    public Double totalPrice(int numberOfProduct, double price) {

        return numberOfProduct * price;

    }

}
