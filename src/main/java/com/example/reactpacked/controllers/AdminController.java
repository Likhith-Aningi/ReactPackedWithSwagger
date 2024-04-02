package com.example.reactpacked.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
    @GetMapping
    public ObjectNode  adminSample(){
        return JsonNodeFactory.instance.objectNode().put("data","hello admin");
    }
}
