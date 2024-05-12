package com.kuspit.MiCasadeBolsa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserBalanceDTO {
    private String idUsuario;
    private Double saldo;

    public UserBalanceDTO(String idUsuario, Double saldo) {
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }
}

