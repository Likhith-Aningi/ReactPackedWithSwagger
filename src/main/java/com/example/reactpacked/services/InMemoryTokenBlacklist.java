package com.example.reactpacked.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

interface TokenBlacklist {
    void addToBlacklist(String token);

    boolean isBlacklisted(String token);
}
@Service
public class InMemoryTokenBlacklist implements TokenBlacklist {
    private Set<String> blacklist = new HashSet<>();

    @Override
    public void addToBlacklist(String token) {
        blacklist.add(token);
    }

    @Override
    public boolean isBlacklisted(String token) {
        return blacklist.contains(token);
    }
}