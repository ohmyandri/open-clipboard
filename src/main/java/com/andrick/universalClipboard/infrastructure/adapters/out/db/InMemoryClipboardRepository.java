package com.andrick.universalClipboard.infrastructure.adapters.out.db;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

@Repository
public class InMemoryClipboardRepository implements ClipboardRepositoryPort {
    final private Map<String, Stack<ClipboardItem> > repository = new HashMap<>();

    @Override
    public void save(ClipboardItem data) {
        repository.computeIfAbsent(data.userId(), k -> new Stack<>()).push(data);
    }

    @Override
    public Optional<ClipboardItem> save(String userId) {
        return Optional.empty();
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
