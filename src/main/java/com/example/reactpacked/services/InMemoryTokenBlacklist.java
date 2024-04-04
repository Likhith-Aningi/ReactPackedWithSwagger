package com.example.reactpacked.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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