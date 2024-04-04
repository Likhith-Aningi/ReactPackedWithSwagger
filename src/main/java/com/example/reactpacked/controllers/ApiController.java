package com.example.reactpacked.controllers;

import java.time.Duration;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactpacked.models.LoginReq;
import com.example.reactpacked.services.InMemoryTokenBlacklist;
import com.example.reactpacked.services.JwtService;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class ApiController {
    @GetMapping
    public ObjectNode test() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        return JsonNodeFactory.instance.objectNode().put("data", "data from spring boot");
    }

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<ObjectNode> login(@RequestBody LoginReq loginObj) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginObj.username(), loginObj.password()));
            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(loginObj.username());
                return ResponseEntity.ok().body(JsonNodeFactory.instance.objectNode().put("token", token));
            }
        } catch (Exception e) {
            log.warn("Error in login :" + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(JsonNodeFactory.instance.objectNode().put("data", "invalid credentials"));
    }
    @Autowired InMemoryTokenBlacklist inMemoryTokenBlacklist;
    @PostMapping("/logout")
    public ResponseEntity<String> logoutToken(@RequestBody String entity) {
        inMemoryTokenBlacklist.addToBlacklist(entity);
        return ResponseEntity.ok("Logged out successfully");
    }

}
