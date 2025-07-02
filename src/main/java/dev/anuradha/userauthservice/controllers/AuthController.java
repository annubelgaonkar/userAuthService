package dev.anuradha.userauthservice.controllers;

import dev.anuradha.userauthservice.dtos.AuthRequestDTO;
import dev.anuradha.userauthservice.dtos.AuthResponseDTO;
import dev.anuradha.userauthservice.dtos.LoginRequestDTO;
import dev.anuradha.userauthservice.models.User;
import dev.anuradha.userauthservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody AuthRequestDTO authRequestDTO){

        User register = authService.register(authRequestDTO.getName(),
                    authRequestDTO.getEmail(),
                    authRequestDTO.getPassword());

        return from(register);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){

    }

    //conversion of user to AuthResponseDTO
    private AuthResponseDTO from(User user){
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setId(user.getId());
        authResponseDTO.setEmail(user.getEmail());
        authResponseDTO.setName(user.getName());

        return authResponseDTO;
    }
}
