package com.andrick.universalClipboard.infrastructure.adapters.out.db.inMemory;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class InMemoryClipboardRepository implements ClipboardRepositoryPort {
    final private Map<String, Stack<ClipboardItem> > repository = new HashMap<>();

    @Override
    public void save(ClipboardItem data) {
        repository.computeIfAbsent(data.userId(), k -> new Stack<>()).push(data);
    }

    @Override
    public Optional<ClipboardItem> get(String userId) {
        Stack<ClipboardItem> stack = repository.get(userId);

        if (stack != null && !stack.isEmpty()) {
            return Optional.of(stack.peek());
        }

        return Optional.empty();
    }


}
