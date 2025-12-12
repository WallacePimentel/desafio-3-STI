package com.wallacepimentel.desafio3.model;

import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    private final String matriculaAluno;
    private List<MatriculaDisciplinaModel> disciplinasDoAluno;

    public AlunoModel (String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
        this.disciplinasDoAluno = new ArrayList<>();
    }

    public void adicionarMatriculaDisciplina(MatriculaDisciplinaModel matriculaDisciplina) {
        this.disciplinasDoAluno.add(matriculaDisciplina);
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public List<MatriculaDisciplinaModel> getDisciplinasDoAluno() {
        return disciplinasDoAluno;
    }

    public void setDisciplinasDoAluno(List<MatriculaDisciplinaModel> disciplinasDoAluno) {
        this.disciplinasDoAluno = disciplinasDoAluno;
    }
}
