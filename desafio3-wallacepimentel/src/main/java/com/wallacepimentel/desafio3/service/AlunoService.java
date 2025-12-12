package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.DTO.CRAlunoDTO;
import com.wallacepimentel.desafio3.model.AlunoModel;
import com.wallacepimentel.desafio3.model.MatriculaDisciplinaModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AlunoService {

    private final HashMap<String, AlunoModel> alunos = new HashMap<>();
    private final DisciplinaService disciplinaService;

    public AlunoService(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    public void adicionarAluno (AlunoModel aluno) {
        this.alunos.put(aluno.getMatriculaAluno(), aluno);
    }

    public AlunoModel buscarAluno (String matriculaAluno) {
        return this.alunos.get(matriculaAluno);
    }

    public double calcularCRAluno (AlunoModel aluno) {
        double somatorioNotas = 0;
        int totalCargaHoraria = 0;

        //Passando por todas as disciplinas do aluno para somar as notas * cargaHoraria e somar cargaHoraria
        for (MatriculaDisciplinaModel matriculasAluno: aluno.getDisciplinasDoAluno()) {

            int cargaHorariaAtual = disciplinaService.buscarDisciplinaPorCodigo(matriculasAluno.getCodigoDisciplina()).getCargaHoraria();

            somatorioNotas += matriculasAluno.getNota() * cargaHorariaAtual;
            totalCargaHoraria += cargaHorariaAtual;
        }

        if (totalCargaHoraria == 0){
            return 0;
        }

        return somatorioNotas / totalCargaHoraria;
    }

    //Criando lista de DTOs dos CRs para exibição
    public List<CRAlunoDTO> listarCRdosAlunosEmDTO () {
        return this.alunos
                .values()
                .stream()
                .map(aluno -> new CRAlunoDTO(aluno.getMatriculaAluno(), calcularCRAluno(aluno)))
                .toList();
    }
}
