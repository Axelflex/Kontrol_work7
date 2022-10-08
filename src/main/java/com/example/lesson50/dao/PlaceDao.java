package com.example.lesson50.dao;

import com.example.lesson50.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlaceDao {

    private final JdbcTemplate jdbcTemplate;

    public Optional<Place> getAllPlaces(){
        String sql = "select * from places";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Place.class)));
    }
}
