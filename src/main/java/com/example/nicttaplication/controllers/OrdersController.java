package com.example.nicttaplication.controllers;

import com.example.nicttaplication.DTO.OrderDTO;
import com.example.nicttaplication.converters.OrderConverter;
import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.models.Product;
import com.example.nicttaplication.service.OrderService;
import com.example.nicttaplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    private OrderService orderService;
    private OrderConverter orderConverter;
    private ProductService productService;

    @Autowired
    public OrdersController(OrderService orderService, OrderConverter converter, ProductService productService) {
        this.orderService = orderService;
        this.orderConverter = converter;
        this.productService = productService;
    }

    @GetMapping()
    public String showAll(Model model) throws SQLException {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "show_all_orders";

    }

    @GetMapping(value = "/new")
    public String newOrder(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("products", products);

        return "order_create";

    }
    @PostMapping(value = "/order-create")
    public String creatOrder(@Valid OrderDTO orderDTO, BindingResult bindingResult) throws SQLException {

        if(bindingResult.hasErrors()){
            return "order_create";
        }
        orderService.save(orderConverter.convert(orderDTO));
        return "redirect:/orders";

    }
    @GetMapping("/order-delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/order-update/{id}")
    public String editOrder(@PathVariable("id") Long id, Model model){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        model.addAttribute("orderDTO", orderDTO);
        return "update_order";
    }

    @PostMapping("/order-update")
    public String Order(@ModelAttribute("orderDTO") OrderDTO orderDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "update_order";
        }
        orderService.save(orderConverter.convert(orderDTO));
        return "redirect:/orders";
    }
}

