package com.test.LeLviv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FunnyLinkController {
    @GetMapping("/funny-link")
    public String funnyImage() {
        return "funny-link";
    }
}
