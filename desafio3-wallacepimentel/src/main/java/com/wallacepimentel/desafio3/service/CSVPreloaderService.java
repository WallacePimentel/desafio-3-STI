package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.model.AlunoModel;
import com.wallacepimentel.desafio3.model.CursoModel;
import com.wallacepimentel.desafio3.model.DisciplinaModel;
import com.wallacepimentel.desafio3.model.MatriculaDisciplinaModel;
import com.wallacepimentel.desafio3.utils.Key;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CSVPreloaderService {
    
    private final AlunoService alunoService;
    private final CursoService cursoService;
    private final DisciplinaService disciplinaService;
    private final MatriculaDisciplinaService matriculaDisciplinaService;
    
    public CSVPreloaderService(AlunoService alunoService, CursoService cursoService, DisciplinaService disciplinaService, MatriculaDisciplinaService matriculaDisciplinaService) {
        this.alunoService = alunoService;
        this.cursoService = cursoService;
        this.disciplinaService = disciplinaService;
        this.matriculaDisciplinaService = matriculaDisciplinaService;
    }
    
    public void lerCSV() {
        try {
            ClassPathResource resource = new ClassPathResource("static/notas.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            
            String linha;
            boolean primeiraLinha = true;

            //Continue para ler a descrição dos items
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                processarLinha(linha);
            }
            
            reader.close();
            
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
        }
    }
    
    private void processarLinha(String linha) {
        String[] dados = linha.split(",");

        //Não pode haver atributo faltante
        if (dados.length != 6) {
            return;
        }

        String matriculaAluno = dados[0].trim();
        String codigoDisciplina = dados[1].trim();
        String codigoCurso = dados[2].trim();
        double nota = Double.parseDouble(dados[3].trim());
        int cargaHoraria = Integer.parseInt(dados[4].trim());
        String anoSemestre = dados[5].trim();


        if (!cursoService.existeCurso(codigoCurso)) {
            CursoModel curso = new CursoModel(codigoCurso);
            cursoService.adicionarCurso(curso);
        }

        if (!disciplinaService.existeDisciplina(codigoDisciplina)) {
            DisciplinaModel disciplina = new DisciplinaModel(codigoDisciplina, codigoCurso, cargaHoraria);
            disciplinaService.adicionarDisciplina(disciplina);
        }

        AlunoModel aluno = alunoService.buscarAluno(matriculaAluno);
        if (aluno == null) {
            aluno = new AlunoModel(matriculaAluno);
            alunoService.adicionarAluno(aluno);
        }
        //Adicionando aluno ao curso caso não esteja
        CursoModel curso = cursoService.buscarCursoPorCodigo(codigoCurso);
        if (!curso.getAlunosDoCurso().contains(aluno)) {
            curso.adicionarAluno(aluno);
        }

        //Criando chave dupla para a criação de uma nova matricula de disciplina de um aluno
        Key keyMatriculaDisciplina = new Key(matriculaAluno, codigoDisciplina);
        if (!matriculaDisciplinaService.existeMatriculaDisciplina(keyMatriculaDisciplina)) {
            MatriculaDisciplinaModel matriculaDisciplina = new MatriculaDisciplinaModel(matriculaAluno, codigoDisciplina, anoSemestre);
            matriculaDisciplinaService.adicionarMatriculaDisciplina(keyMatriculaDisciplina, matriculaDisciplina);
            matriculaDisciplina.setNota(nota);
        }
        
        // Adicionando matrícula ao aluno
        MatriculaDisciplinaModel matriculaDisciplina = matriculaDisciplinaService.buscarMatriculaDisciplina(keyMatriculaDisciplina);
        aluno.adicionarMatriculaDisciplina(matriculaDisciplina);
    }
}