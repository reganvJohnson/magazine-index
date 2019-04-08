package com.lorisoft.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MagazineController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot and regan!";
    }

}