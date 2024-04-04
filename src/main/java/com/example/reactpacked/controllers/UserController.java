package com.example.reactpacked.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Operation(
            tags = "User data api",
            description = "This endpoint/api is only available for users having admin role and user role",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized to get admin data",
                            responseCode = "401"
                    ),
                    @ApiResponse(
                            description = "Invalid credentials",
                            responseCode = "403"
                    )
            },
            security =@SecurityRequirement(name = "jwtSec")
    )
    @GetMapping 
    public ObjectNode sampleUserData(){
        return JsonNodeFactory.instance.objectNode().put("data", "hello user , this is available for admin and user");
    }
}
