package com.example.nicttaplication.price;

import org.springframework.stereotype.Component;

@Component
public class Price {

    public static Double totalPrice(int numberOfProduct, double price) {

        return numberOfProduct * price;

    }

}
