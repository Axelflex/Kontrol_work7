package com.example.lesson50.dao;

import com.example.lesson50.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DishDao {

    private final JdbcTemplate jdbcTemplate;

    public Optional<Dish> getAllDishes(Long place_id){
        String sql = "select * from dishes " +
                "where place_id = ?;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dish.class), place_id));
    }
}
