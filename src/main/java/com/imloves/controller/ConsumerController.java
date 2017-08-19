package com.imloves.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wujianchuan
 * 2017/8/17 20:38
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/logout")
    public void logout() {
    }
}
