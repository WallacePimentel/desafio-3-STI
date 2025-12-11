package com.wallacepimentel.desafio3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AlunoModel {
    private final String matriculaAluno;
    private String codigoCurso;
    private List<MatriculaDisciplinaModel> disciplinasDoAluno;

    public AlunoModel (String matriculaAluno, String codigoCurso) {
        this.matriculaAluno = matriculaAluno;
        this.codigoCurso = codigoCurso;
        this.disciplinasDoAluno = new ArrayList<>();
    }

    public void adicionarMatriculaDisciplina(MatriculaDisciplinaModel matriculaDisciplina) {
        this.disciplinasDoAluno.add(matriculaDisciplina);
    }
}
