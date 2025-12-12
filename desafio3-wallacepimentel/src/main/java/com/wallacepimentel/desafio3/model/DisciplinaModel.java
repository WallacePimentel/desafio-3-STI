package com.wallacepimentel.desafio3.model;

public class DisciplinaModel {
    private final String codigoDisciplina;
    private String codigoCurso;
    private int cargaHoraria;

    public DisciplinaModel (String codigoDisciplina, String codigoCurso, int cargaHoraria) {
        this.codigoDisciplina = codigoDisciplina;
        this.codigoCurso = codigoCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
