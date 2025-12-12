package com.wallacepimentel.desafio3.model;

public class MatriculaDisciplinaModel {
    private String matriculaAluno;
    private String codigoDisciplina;
    private double nota;
    private String anoSemestre;

    //Inicializando a nota com 0 para caso de abandono
    public MatriculaDisciplinaModel(String matriculaAluno, String codigoDisciplina, String anoSemestre) {
        this.matriculaAluno = matriculaAluno;
        this.codigoDisciplina = codigoDisciplina;
        this.nota = 0;
        this.anoSemestre = anoSemestre;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAnoSemestre() {
        return anoSemestre;
    }

    public void setAnoSemestre(String anoSemestre) {
        this.anoSemestre = anoSemestre;
    }
}
