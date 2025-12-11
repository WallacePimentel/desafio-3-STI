package com.wallacepimentel.desafio3.model;

import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    private final String matriculaAluno;
    private String codigoCurso;
    private List<DisciplinaModel> disciplinasDoAluno;

    public AlunoModel (String matriculaAluno, String codigoCurso) {
        this.matriculaAluno = matriculaAluno;
        this.codigoCurso = codigoCurso;
        this.disciplinasDoAluno = new ArrayList<>();
    }
}
