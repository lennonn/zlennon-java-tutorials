package com.zlennon.transaction.controller;

import com.zlennon.transaction.entity.Order;
import com.zlennon.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/create")
    public ResponseEntity createOrder(@RequestBody  Order order) throws Exception {
       return  new ResponseEntity(orderService.cretateOrder(order), HttpStatus.OK) ;
    }
}
