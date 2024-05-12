package com.kuspit.MiCasadeBolsa.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;

@Setter @Getter
public class LoginRequestDTO {

    private String email;
    private String password;

    LoginRequestDTO(String email, String password){
        this.email=email;
        this.password=password;
    }

}
