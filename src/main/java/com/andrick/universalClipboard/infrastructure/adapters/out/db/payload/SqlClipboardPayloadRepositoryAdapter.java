package com.andrick.universalClipboard.infrastructure.adapters.out.db.payload;

import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import com.andrick.universalClipboard.domain.models.clipboard.ContentType;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SqlClipboardPayloadRepositoryAdapter implements ClipboardRepositoryPort {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<ClipboardItem> clipboardItemRowMapper = (rs, rowNum) -> {
        OffsetDateTime odt = rs.getObject("created_at", OffsetDateTime.class);
        LocalDateTime createdAt = (odt != null) ? odt.toLocalDateTime() : null;

        return new ClipboardItem(
                UUID.fromString(rs.getString("id")),
                rs.getString("user_id"),
                rs.getString("origin_device_id"),
                ContentType.valueOf(rs.getString("content_type")),
                rs.getString("payload"),
                createdAt
        );
    };

    public SqlClipboardPayloadRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ClipboardItem save(ClipboardItem item) {
        String sql = """
            INSERT INTO clipboard_payloads (id, user_id, content_type, payload, origin_device_id)
            VALUES (?, ?, ?, ?, ?)
            RETURNING id, user_id, origin_device_id, content_type, payload, created_at
            """;

        return jdbcTemplate.queryForObject(
                sql,
                clipboardItemRowMapper,
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
            ClipboardItem item = jdbcTemplate.queryForObject(sql, clipboardItemRowMapper, userId);
            return Optional.ofNullable(item);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}