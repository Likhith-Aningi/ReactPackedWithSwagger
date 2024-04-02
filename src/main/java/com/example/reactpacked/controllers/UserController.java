package com.example.reactpacked.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping 
    public ObjectNode sampleUserData(){
        return JsonNodeFactory.instance.objectNode().put("data", "hello user , this is available for admin and user");
    }
}
