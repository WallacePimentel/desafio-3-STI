package com.wallacepimentel.desafio3.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaModel {
    private final String codigoDisciplina;
    private int cargaHoraria;

    public DisciplinaModel (String codigoDisciplina, int cargaHoraria) {
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHoraria = cargaHoraria;
    }
}
