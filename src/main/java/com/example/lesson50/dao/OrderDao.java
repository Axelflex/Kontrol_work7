package com.example.lesson50.dao;

import com.example.lesson50.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public String makeOrder(Long user_id, Long dish_id){
        String sql = "insert into order(user_id, dish_id, date_time_of_order) " +
                "values(?, ?, LocalDateTime.now());";
        jdbcTemplate.update(sql, new BeanPropertyRowMapper<>(Order.class), user_id, dish_id);
        return "Order has been placed";
    }
}
