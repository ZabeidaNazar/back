package com.test.LeLviv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {
    @GetMapping("/cat")
    public String cat() {
        return "cat";
    }
}