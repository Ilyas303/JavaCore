package org.example.repository.impl;

import org.example.model.Users;
import org.example.repository.UsersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Users> findById(Long id) {
        String sql = "SELECT * FROM users u WHERE u.id = ?";
        try {
            Users user = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper());
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, rowMapper());
    }

    private RowMapper<Users> rowMapper() {
        return (rs, rowNum) -> {
            Users users = new Users();
            users.setId(rs.getLong("id"));
            users.setFio(rs.getString("fio"));
            return users;
        };
    }
}