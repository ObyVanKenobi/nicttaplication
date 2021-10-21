package com.example.nicttaplication.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrdersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrdersController ordersController;

    @Test
    public void showAll() throws Exception {
        this.mockMvc.perform(get("/orders"))
                .andExpect(status().is2xxSuccessful());
    }
}