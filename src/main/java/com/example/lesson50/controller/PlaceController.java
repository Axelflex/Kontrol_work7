package com.example.lesson50.controller;

import com.example.lesson50.dao.PlaceDao;
import com.example.lesson50.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceDao placeDao;
    @GetMapping("/getAllPlaces")
    private ResponseEntity<Optional<Place>> getAllPlaces(){
        return new ResponseEntity<>(placeDao.getAllPlaces(), HttpStatus.OK);
    }
}
