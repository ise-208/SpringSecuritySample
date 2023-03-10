package com.example.springsecuritysample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecuritySampleController {
    @RequestMapping("/home")
    public String home(){
        return "{}";
    }
}
