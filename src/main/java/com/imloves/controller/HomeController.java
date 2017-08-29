package com.imloves.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "home")
    public String home() {
        return "Welcome To I'm Loves!";
    }

}
