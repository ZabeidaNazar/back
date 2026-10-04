package com.test.LeLviv.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String thing() {
        return "Hello, world!!!";
    }
}
