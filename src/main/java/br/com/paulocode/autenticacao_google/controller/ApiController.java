package br.com.paulocode.autenticacao_google.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ApiController {
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
