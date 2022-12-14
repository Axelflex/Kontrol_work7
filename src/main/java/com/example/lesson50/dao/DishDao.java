package com.example.lesson50.dao;

import com.example.lesson50.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DishDao {

    private final JdbcTemplate jdbcTemplate;

    public void deleteAll() {
        String query = "delete from dishes";
        jdbcTemplate.update(query);
    }
    public void save (String name, String type, Long place_id, Integer price) {
        String sql = "insert into dishes (name, type, place_id, price) " +
                "values (?, ?, ?, ?);";
        jdbcTemplate.update(sql, name, type, place_id, price);
    }

    public List<Dish> getAllDishes(Long place_id){
        String sql = "select * from dishes " +
                "where place_id = ?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class), place_id);
    }
}
