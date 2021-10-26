package com.example.nicttaplication.restcontrollers;

import com.example.nicttaplication.DTO.OrderDTO;
import com.example.nicttaplication.apiDTO.OrderCreateDTO;
import com.example.nicttaplication.apiDTO.OrderUpdateDTO;
import com.example.nicttaplication.converters.OrderConverter;
import com.example.nicttaplication.models.Order;
import com.example.nicttaplication.service.OrderService;
import com.example.nicttaplication.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/orders")
@Api(value = "CRUD СЕРВИС ДЛЯ ORDERS")
public class OrdersRestController {

    private OrderService orderService;
    private OrderConverter orderConverter;
    private ProductService productService;

    @Autowired
    public OrdersRestController(OrderService orderService, OrderConverter orderConverter, ProductService productService) {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "возврашает все заказы")
    public ResponseEntity<List<Order>> showAll() {
        List<Order> orders = orderService.findAll();

        if ((orders.isEmpty())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "сохраняет новый заказ")
    public ResponseEntity<OrderCreateDTO> saveOrder(@RequestBody @Valid OrderCreateDTO orderDTO) {

        if (orderDTO == null) {
            return new ResponseEntity<OrderCreateDTO>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(orderConverter.convertApiDTO(orderDTO));
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "обновляет выбранный заказ")
    public ResponseEntity<OrderUpdateDTO> updateOrder(@RequestBody @Valid OrderUpdateDTO orderDTO) {
        HttpHeaders headers = new HttpHeaders();

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(orderConverter.convertApiDTOForUpdate(orderDTO));

        return new ResponseEntity<>(orderDTO, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "удаляет заказ")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("id") Long id) {
        Order order = this.orderService.findById(id);

        if (order == null) {
            return new ResponseEntity<OrderDTO>(HttpStatus.NOT_FOUND);
        }

        this.orderService.deleteOrder(id);

        return new ResponseEntity<OrderDTO>(HttpStatus.NO_CONTENT);
    }

}