package com.wallacepimentel.desafio3.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaModel {
    private final String codigoDisciplina;
    private String codigoCurso;
    private int cargaHoraria;

    public DisciplinaModel (String codigoDisciplina, String codigoCurso, int cargaHoraria) {
        this.codigoDisciplina = codigoDisciplina;
        this.codigoCurso = codigoCurso;
        this.cargaHoraria = cargaHoraria;
    }
}
