package com.bookzy.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @GetMapping("/home") //Giving the location where the controller will display the info. 
    public String showHomePage() {

        System.out.println("Welcome to the Bookzy Home Page");

        return "home";
    }
}