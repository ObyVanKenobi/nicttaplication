package com.example.nicttaplication.converters;

import com.example.nicttaplication.DTO.OrderDTO;
import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.models.OrderDetails;
import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.price.PriceFactory;
import com.example.nicttaplication.service.OrderDetailsService;
import com.example.nicttaplication.service.OrderService;
import com.example.nicttaplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OrderConverter  {

        final OrderService orderService;
        final OrderDetailsService orderDetailsService;
        final ProductService productService;
        final PriceFactory priceFactory;

    @Autowired
    public OrderConverter(OrderService orderService, OrderDetailsService orderDetailsService, ProductService productService, PriceFactory priceFactory) {
        this.orderService = orderService;
        this.orderDetailsService = orderDetailsService;
        this.productService = productService;
        this.priceFactory = priceFactory;
    }


    public Order convert(OrderDTO orderDTO){
            Order order = new Order();
            if(orderDTO.getId() != null) {
                order = orderService.findById(orderDTO.getId());
                order.setCustomerEmail(orderDTO.getEmail());
                if(orderDTO.getCountOfProduct() != null) {
                    OrderDetails orderDetails = order.getOrderDetails();
                    orderDetails.setNumberOfProduct(orderDTO.getCountOfProduct());
                    orderDetails.setTotalPrice(priceFactory.totalPrice(orderDTO.getCountOfProduct(),orderDetails.getPrice()));
                }

            }
            else {
                Product product = productService.findById(orderDTO.getProductId());
                OrderDetails orderDetails = new OrderDetails();

                orderDetails.setProduct(product);
                orderDetails.setNumberOfProduct(orderDTO.getCountOfProduct());
                orderDetails.setPrice(product.getPrice());
                orderDetails.setTotalPrice(priceFactory.totalPrice(orderDTO.getCountOfProduct(), product.getPrice()));

                order.setOrderDetails(orderDetails);
                order.setCustomerEmail(orderDTO.getEmail());
                order.setOrderTime(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            }

            return order;
        }

    }

