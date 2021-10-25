package com.example.nicttaplication.price;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class PriceTest {

    @Test
    void totalPrice() {

        double price = 55.00;
        int quantity = 9;
        double sum = price * quantity;
        Assert.isTrue(Price.totalPrice(quantity, price) == sum, "ошибка цены");
    }
}