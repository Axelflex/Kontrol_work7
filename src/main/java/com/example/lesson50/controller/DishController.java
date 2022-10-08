package com.example.lesson50.controller;

import com.example.lesson50.dao.DishDao;
import com.example.lesson50.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishDao dishDao;

    @GetMapping("/getAllDishes")
    public ResponseEntity<Optional<Dish>> getAllDishes(@RequestParam Long place_id){
        return new ResponseEntity<>(dishDao.getAllDishes(place_id), HttpStatus.OK);
    }
    @PostMapping("/creaDish")
    public void createUser(@RequestParam String name,
                           @RequestParam String type,
                           @RequestParam Long place_id,
                           @RequestParam Integer price){
        dishDao.save(name, type, place_id, price);
    }
}
