package com.andrick.universalClipboard.infrastructure.adapters.out.db;

import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import com.andrick.universalClipboard.domain.models.clipboard.ContentType;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SqlClipboardPayloadRepositoryAdapter implements ClipboardRepositoryPort {

    private final JdbcTemplate jdbcTemplate;

    public SqlClipboardPayloadRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(ClipboardItem item) {
        String sql = "INSERT INTO clipboard_payloads (id, user_id, content_type, payload, origin_device_id) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                item.id().toString(),
                item.userId(),
                item.contentType().name(),
                item.payload(),
                item.originDeviceId()
        );
    }

    @Override
    public Optional<ClipboardItem> get(String userId) {
        String sql = "SELECT id, user_id, content_type, payload, origin_device_id, created_at " +
                "FROM clipboard_payloads WHERE user_id = ? ORDER BY created_at DESC LIMIT 1";

        try {
            ClipboardItem item = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new ClipboardItem(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("user_id"),
                    ContentType.valueOf(rs.getString("content_type")),
                    rs.getString("payload"),
                    rs.getString("origin_device_id"),
                    rs.getObject("created_at", LocalDateTime.class)
            ), userId);

            return Optional.ofNullable(item);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}