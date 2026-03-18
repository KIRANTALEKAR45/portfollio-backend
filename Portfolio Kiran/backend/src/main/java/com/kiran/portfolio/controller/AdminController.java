package com.kiran.portfolio.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")
public class AdminController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {

        String username = credentials.get("username");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();

        if ("Kiran".equals(username) && "Kiran@123".equals(password)) {
            response.put("status", "success");
            response.put("message", "Login Success");
        } else {
            response.put("status", "error");
            response.put("message", "Invalid Credentials");
        }

        return response;
    }
}