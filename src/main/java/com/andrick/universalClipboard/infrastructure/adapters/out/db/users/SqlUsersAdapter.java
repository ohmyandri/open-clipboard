package com.andrick.universalClipboard.infrastructure.adapters.out.db.users;

import com.andrick.universalClipboard.domain.models.user.User;
import com.andrick.universalClipboard.domain.ports.out.UserRepositoryPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SqlUsersAdapter implements UserRepositoryPort {
    private final JdbcTemplate jdbcTemplate;

    public SqlUsersAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (user_id, email) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                user.userId(),
                user.email()
        );
    }

    @Override
    public void remove(String userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        jdbcTemplate.update(sql, userId);
    }
}
