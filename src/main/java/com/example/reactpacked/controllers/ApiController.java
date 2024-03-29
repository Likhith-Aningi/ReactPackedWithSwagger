package com.example.reactpacked.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {
    @GetMapping
    public ObjectNode test() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        return JsonNodeFactory.instance.objectNode().put("data","data from spring boot");
    }
}
