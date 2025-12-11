package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.DTO.CRAlunoDTO;
import com.wallacepimentel.desafio3.DTO.CRCursoDTO;
import com.wallacepimentel.desafio3.model.AlunoModel;
import com.wallacepimentel.desafio3.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
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

    //Calculando CR médio dos alunos de um curso
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

    //Criando lista de DTOs dos CRs para exibição
    private List<CRCursoDTO> listarCRdosAlunosEmDTO () {
        return this.cursos
                .values()
                .stream()
                .map(curso -> new CRCursoDTO(curso.getCodigoCurso(), calcularCRCurso(curso)))
                .toList();
    }
}
