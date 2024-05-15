package com.kuspit.MiCasadeBolsa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionAvailableDTO {
    private String id_usuario;
    private int id_action;

    public TransactionAvailableDTO() {
    }

    public TransactionAvailableDTO(String id_usuario, int id_action) {
        this.id_usuario = id_usuario;
        this.id_action = id_action;
    }

}
