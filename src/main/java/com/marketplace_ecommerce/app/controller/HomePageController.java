package com.marketplace_ecommerce.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author j0975
 */
@Controller
@CrossOrigin("http://localhost:4200")
public class HomePageController {

    @GetMapping("/home")
    public String showHomePage(){

        return "homePage";
    }
}
