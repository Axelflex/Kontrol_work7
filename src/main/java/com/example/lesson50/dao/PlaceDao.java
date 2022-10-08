package com.example.lesson50.dao;

import com.example.lesson50.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlaceDao {

    private final JdbcTemplate jdbcTemplate;

    public void deleteAll() {
        String query = "delete from places";
        jdbcTemplate.update(query);
    }
    public void save (String name, String description) {
        String sql = "insert into places(name, description) " +
                "values (?, ?);";
        jdbcTemplate.update(sql, name, description);
    }

    public List<Place> getAllPlaces(){
        String sql = "select * from places";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Place.class));
    }
}
