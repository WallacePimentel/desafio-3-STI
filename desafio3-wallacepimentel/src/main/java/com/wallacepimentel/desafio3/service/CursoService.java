package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.model.AlunoModel;
import com.wallacepimentel.desafio3.model.CursoModel;

import java.util.HashMap;

public class CursoService {

    private final HashMap<String, CursoModel> cursos = new HashMap<>();
    private AlunoService alunoService;

    public CursoService (AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public void adicionarCurso (CursoModel curso) {
        this.cursos.put(curso.getCodigoCurso(), curso);
    }

    public CursoModel buscarCursoPorCodigo (String codigoCurso) {
        return this.cursos.get(codigoCurso);
    }

    public boolean existeCurso (String codigoCurso) {
        return this.cursos.containsKey(codigoCurso);
    }

    public double calcularCRCurso (CursoModel curso) {
        int totalAlunos = curso.getAlunosDoCurso().size();
        double somatorioCRs  = 0;

        for (AlunoModel aluno : curso.getAlunosDoCurso()) {
            somatorioCRs += alunoService.calcularCRAluno(aluno);
        }

        if (totalAlunos == 0) {
            return 0;
        }

        return somatorioCRs / totalAlunos;
    }
}
