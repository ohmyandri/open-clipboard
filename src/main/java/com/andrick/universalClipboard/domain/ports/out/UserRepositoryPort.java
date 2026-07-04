package com.andrick.universalClipboard.domain.ports.out;

import com.andrick.universalClipboard.domain.models.user.User;

public interface UserRepositoryPort {
    void save(User user);
    void remove(String userId);
}
