package com.example.reactpacked.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Hidden
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            return switch (statusCode) {
                case 400 -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
                case 401-> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("400 Unauthorized");
                case 403 -> ResponseEntity.status(HttpStatus.FORBIDDEN).body("403 Forbidden");
                case 404 -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Not Found");
                case 405 -> ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("405 Method Not Allowed");
                default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred contr.");
            };
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred controller.");
    }


}
