package com.example.reactpacked.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
    @Operation(
            tags = "Admin data api",
            description = "This endpoint/api is only available for users having admin role",
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
    public ObjectNode adminSample() {
        return JsonNodeFactory.instance.objectNode().put("data", "hello admin");
    }
}
