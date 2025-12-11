package com.wallacepimentel.desafio3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CursoModel {
    private final String codigoCurso;
    private List<AlunoModel> alunosDoCurso;

    public CursoModel (String codigoCurso) {
        this.codigoCurso = codigoCurso;
        this.alunosDoCurso = new ArrayList<>();
    }

    public void adicionarAluno(AlunoModel aluno) {
        this.alunosDoCurso.add(aluno);
    }
}
