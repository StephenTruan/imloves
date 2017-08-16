package com.imloves.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(@RequestParam("openid") String openId) {
        return "Welcome To I'm Loves!" + openId;
    }

}
