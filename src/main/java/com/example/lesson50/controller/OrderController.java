package com.example.lesson50.controller;

import com.example.lesson50.dao.OrderDao;
import com.example.lesson50.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderDao orderDao;

    @PostMapping("/makeOrder")
    public ResponseEntity<?> makeOrder(@RequestParam Long user_id, @RequestParam Long dish_id){
        return new ResponseEntity<>(orderDao.makeOrder(user_id, dish_id), HttpStatus.OK);
    }
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam Long user_id){
        return new ResponseEntity<>(orderDao.getAllOrders(user_id), HttpStatus.OK);
    }
}
