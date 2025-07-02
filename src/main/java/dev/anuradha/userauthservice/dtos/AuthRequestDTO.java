package dev.anuradha.userauthservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequestDTO {

    private String name;
    private String email;
    private String password;

}
