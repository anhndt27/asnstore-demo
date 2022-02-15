package com.trinhvannam.userapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class LoginController {

    @GetMapping(value = "/user")
    public String userApi(){
        return "Returned successfully from User API";
    }

    @GetMapping(value = "/admin")
    public String adminApi(){
        return "Returned successfully from Admin API";
    }
}
