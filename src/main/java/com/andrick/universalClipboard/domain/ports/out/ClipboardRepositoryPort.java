package com.andrick.universalClipboard.domain.ports.out;

import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;

import java.util.Optional;

public interface ClipboardRepositoryPort {
    public void save(ClipboardItem data);
    public Optional<ClipboardItem> save(String userId);

    public Optional<ClipboardItem> get(String userId);
}
