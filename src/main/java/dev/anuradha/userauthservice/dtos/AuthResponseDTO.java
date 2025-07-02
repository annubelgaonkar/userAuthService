package dev.anuradha.userauthservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDTO {

    private Long id;
    private String name;
    private String email;
}
