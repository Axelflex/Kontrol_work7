package com.example.lesson50.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder encoder;

    public void deleteAll() {
        String query = "delete from usrs";
        jdbcTemplate.update(query);
    }

    public void save (String email, String username, String password) {
        String sql = "insert into usrs (email, username, password, enabled) " +
                "values (?, ?, ?, true);";
        jdbcTemplate.update(sql, email, username, encoder.encode(password));
    }
}
