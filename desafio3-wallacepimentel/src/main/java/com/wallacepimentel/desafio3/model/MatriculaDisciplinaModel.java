package com.wallacepimentel.desafio3.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatriculaDisciplinaModel {
    private String matriculaAluno;
    private String codigoDisciplina;
    private int nota;
    private String anoSemestre;

    //Inicializando a nota com 0 para caso de abandono
    public MatriculaDisciplinaModel(String matriculaAluno, String codigoDisciplina, String anoSemestre) {
        this.matriculaAluno = matriculaAluno;
        this.codigoDisciplina = codigoDisciplina;
        this.nota = 0;
        this.anoSemestre = anoSemestre;
    }
}
