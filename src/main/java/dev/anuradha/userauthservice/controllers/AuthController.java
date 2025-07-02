package dev.anuradha.userauthservice.controllers;

import dev.anuradha.userauthservice.dtos.AuthRequestDTO;
import dev.anuradha.userauthservice.dtos.AuthResponseDTO;
import dev.anuradha.userauthservice.dtos.LoginRequestDTO;
import dev.anuradha.userauthservice.models.User;
import dev.anuradha.userauthservice.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody AuthRequestDTO authRequestDTO){

        User registerUser = authService.register(authRequestDTO.getName(),
                    authRequestDTO.getEmail(),
                    authRequestDTO.getPassword());

        return from(registerUser);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        User login = authService.login(loginRequestDTO.getEmail(),
                loginRequestDTO.getPassword());

        return from(login);
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
