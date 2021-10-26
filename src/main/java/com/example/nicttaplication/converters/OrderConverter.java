package com.example.nicttaplication.converters;

import com.example.nicttaplication.DTO.OrderDTO;
import com.example.nicttaplication.apiDTO.OrderApiDTO;
import com.example.nicttaplication.apiDTO.OrderApiUpdateDTO;
import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.models.OrderDetails;
import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.service.OrderDetailsService;
import com.example.nicttaplication.service.OrderService;
import com.example.nicttaplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderConverter {

    final OrderService orderService;
    final OrderDetailsService orderDetailsService;
    final ProductService productService;

    @Autowired
    public OrderConverter(OrderService orderService, OrderDetailsService orderDetailsService, ProductService productService) {
        this.orderService = orderService;
        this.orderDetailsService = orderDetailsService;
        this.productService = productService;
    }

    public Order convert(OrderDTO orderDTO) {
        Order order = new Order();
        if (orderDTO.getId() != null) {
            order = orderService.findById(orderDTO.getId());
            order.setCustomerEmail(orderDTO.getEmail());


        } else {
            List<OrderDetails> orderDetailsList = new ArrayList<>();
            for (Long id : orderDTO.getProductIdList()) {
                Product product = productService.findById(id);
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setProduct(product);
                orderDetails.setNumberOfProduct(orderDTO.getProductIdList().size());
                orderDetails.setPrice(product.getPrice());
                orderDetails.setTotalPrice(product.getPrice());
                orderDetailsList.add(orderDetails);

            }
            order.setOrderDetails(orderDetailsList);
            order.setOrderTime(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            order.setCustomerEmail(orderDTO.getEmail());


        }
        return order;


    }

    public Order convertApiDTO(OrderApiDTO orderDTO) {
        Order order = new Order();
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        for (Long id : orderDTO.getProductIdList()) {
            Product product = productService.findById(id);
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProduct(product);
            orderDetails.setNumberOfProduct(orderDTO.getProductIdList().size());
            orderDetails.setPrice(product.getPrice());
            orderDetails.setTotalPrice(product.getPrice());
            orderDetailsList.add(orderDetails);

        }
        order.setOrderDetails(orderDetailsList);
        order.setOrderTime(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        order.setCustomerEmail(orderDTO.getEmail());

        return order;

    }

    public Order convertApiDTOForUpdate(OrderApiUpdateDTO orderDTO) {
        Order order = orderService.findById(orderDTO.getId());
        order.setCustomerEmail(orderDTO.getEmail());
        return order;


    }
}
