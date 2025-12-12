package com.wallacepimentel.desafio3.model;


import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    private final String codigoCurso;
    private List<DisciplinaModel> disciplinasDoCurso;
    private List<AlunoModel> alunosDoCurso;

    public CursoModel (String codigoCurso) {
        this.codigoCurso = codigoCurso;
        this.disciplinasDoCurso = new ArrayList<>();
        this.alunosDoCurso = new ArrayList<>();
    }

    public void adicionarDisciplina(DisciplinaModel disciplina) {
        this.disciplinasDoCurso.add(disciplina);
    }

    public void adicionarAluno (AlunoModel aluno) {
        this.alunosDoCurso.add(aluno);
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public List<DisciplinaModel> getDisciplinasDoCurso() {
        return disciplinasDoCurso;
    }

    public void setDisciplinasDoCurso(List<DisciplinaModel> disciplinasDoCurso) {
        this.disciplinasDoCurso = disciplinasDoCurso;
    }

    public List<AlunoModel> getAlunosDoCurso() {
        return alunosDoCurso;
    }

    public void setAlunosDoCurso(List<AlunoModel> alunosDoCurso) {
        this.alunosDoCurso = alunosDoCurso;
    }
}
