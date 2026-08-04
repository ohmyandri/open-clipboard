package com.andrick.universalClipboard.infrastructure.adapters.out.db.devices;

import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.models.device.DeviceType;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlDevicesAdapter implements DevicesRepositoryPort {

    private final JdbcTemplate jdbcTemplate;

    public SqlDevicesAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Device> findDevicesByUserId(String userId) {
        String sql = "SELECT device_id, user_id, device_name, device_type FROM devices WHERE user_id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Device(
                rs.getString("device_id"),
                rs.getString("user_id"),
                rs.getString("device_name"),
                DeviceType.valueOf(rs.getString("device_type").toUpperCase())
        ), userId);
    }

    @Override
    public void addDevice(Device device) {
        String sql = "INSERT INTO devices (device_id, user_id, device_name, device_type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                device.deviceId(),
                device.userId(),
                device.deviceName(),
                device.deviceType().name()
        );
    }

    @Override
    public boolean removeDevice(String deviceId) {
        String DELETE = "DELETE FROM devices WHERE device_id = ?";
        return jdbcTemplate.update(DELETE, deviceId) == 1;
    }
}
