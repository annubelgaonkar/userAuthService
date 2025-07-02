package dev.anuradha.userauthservice.controllers;

import dev.anuradha.userauthservice.dtos.AuthRequestDTO;
import dev.anuradha.userauthservice.dtos.AuthResponseDTO;
import dev.anuradha.userauthservice.dtos.LoginRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody AuthRequestDTO authRequestDTO){
        return null;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }
}
