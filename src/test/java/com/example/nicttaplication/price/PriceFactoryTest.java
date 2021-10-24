package com.example.nicttaplication.price;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class PriceFactoryTest {

    @Test
    void totalPrice() {

        double price = 55.00;
        int quantity = 9;
        double sum = price * quantity;

        PriceFactory priceFactory = new PriceFactory();
        Assert.isTrue(priceFactory.totalPrice(quantity, price) == sum, "ошибка цены");
    }
}