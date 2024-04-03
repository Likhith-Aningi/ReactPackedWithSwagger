package com.example.reactpacked.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            switch (statusCode) {
                case 400:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
                case 403:
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("403 Forbidden");
                case 404:
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Not Found");
                case 405:
                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("405 Method Not Allowed");
                default:
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred contr.");
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred controller.");
    }


}
