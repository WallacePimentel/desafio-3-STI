package com.wallacepimentel.desafio3.model;

import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    private final String codigoCurso;
    private List<AlunoModel> alunosDoCurso;

    public CursoModel (String codigoCurso) {
        this.codigoCurso = codigoCurso;
        this.alunosDoCurso = new ArrayList<>();
    }
}
