package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

;

/**
 * @author Administrator
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
