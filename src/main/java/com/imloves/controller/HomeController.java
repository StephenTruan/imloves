package com.imloves.controller;

import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    SysUserRepository sysUserRepository;

    @GetMapping(value = "home")
    public String home() {

        return "Welcome To I'm Loves!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "users")
    public List<SysUser> users() {

        return sysUserRepository.findAll();
    }
}
