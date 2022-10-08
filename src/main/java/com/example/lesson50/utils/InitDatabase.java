package com.example.lesson50.utils;

import com.example.lesson50.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Configuration
public class InitDatabase {
    private final UserDao userDao;
    private final PlaceDao placeDao;
    private final OrderDao orderDao;
    private final DishDao dishDao;

    private final PasswordEncoder encoder;
    private final JdbcTemplate jdbcTemplate;

    private void restart(){
        String sql = "ALTER SEQUENCE usrs_id_seq RESTART WITH 1; " +
                "ALTER SEQUENCE place_id_seq RESTART WITH 1; " +
                "ALTER SEQUENCE orders_id_seq RESTART WITH 1; " +
                "ALTER SEQUENCE dishes_id_seq RESTART WITH 1; ";
        jdbcTemplate.update(sql);
    }


    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
            orderDao.deleteAll();
            dishDao.deleteAll();
            userDao.deleteAll();
            placeDao.deleteAll();




            restart();

            userDao.save(GenerateData.randomEmail(), GenerateData.randomPersonName(), "qwe");
            userDao.save(GenerateData.randomEmail(), GenerateData.randomPersonName(), "qwe");
            userDao.save(GenerateData.randomEmail(), GenerateData.randomPersonName(), "qwe");
            userDao.save(GenerateData.randomEmail(), GenerateData.randomPersonName(), "qwe");

            placeDao.save(GenerateData.randomPlace().name, GenerateData.randomPlace().description);
            placeDao.save(GenerateData.randomPlace().name, GenerateData.randomPlace().description);
            placeDao.save(GenerateData.randomPlace().name, GenerateData.randomPlace().description);
            placeDao.save(GenerateData.randomPlace().name, GenerateData.randomPlace().description);

            dishDao.save(GenerateData.randomDish().name, GenerateData.randomDish().type, 1L, 100);
            dishDao.save(GenerateData.randomDish().name, GenerateData.randomDish().type, 2L, 150);
            dishDao.save(GenerateData.randomDish().name, GenerateData.randomDish().type, 3L, 120);
            dishDao.save(GenerateData.randomDish().name, GenerateData.randomDish().type, 4L, 199);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            orderDao.save(1L, 1L, LocalDateTime.parse("2022-10-02 12:30", formatter));
            orderDao.save(2L, 1L, LocalDateTime.parse("2022-10-12 01:24", formatter));
            orderDao.save(2L, 4L, LocalDateTime.parse("2022-10-03 07:50", formatter));
            orderDao.save(3L, 3L, LocalDateTime.parse("2022-10-19 21:11", formatter));
            orderDao.save(3L, 2L, LocalDateTime.parse("2022-10-05 15:15", formatter));
            orderDao.save(4L, 3L, LocalDateTime.parse("2022-10-17 18:47", formatter));
        };
    }
}
