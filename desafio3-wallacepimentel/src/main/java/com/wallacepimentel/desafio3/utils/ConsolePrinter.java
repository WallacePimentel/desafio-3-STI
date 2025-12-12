package com.wallacepimentel.desafio3.utils;

import com.wallacepimentel.desafio3.DTO.CRAlunoDTO;
import com.wallacepimentel.desafio3.DTO.CRCursoDTO;
import com.wallacepimentel.desafio3.service.AlunoService;
import com.wallacepimentel.desafio3.service.CursoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsolePrinter implements CommandLineRunner {
    
    private final LeitorCSV leitorCsv;
    private final AlunoService alunoService;
    private final CursoService cursoService;
    
    public ConsolePrinter(LeitorCSV leitorCsv,
                          AlunoService alunoService,
                          CursoService cursoService) {
        this.leitorCsv = leitorCsv;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    //Run principal para mostrar informações no console
    @Override
    public void run(String... args) throws Exception {
        leitorCsv.lerCSV();
        
        // Exibe os resultados conforme especificado no desafio
        exibirResultados();
    }
    
    private void exibirResultados() {
        System.out.println("------- O CR dos alunos é: --------");
        
        List<CRAlunoDTO> crsAlunos = alunoService.listarCRdosAlunosEmDTO();
        crsAlunos.stream()
                .sorted((a, b) -> a.matriculaAluno().compareTo(b.matriculaAluno()))
                .forEach(cr -> System.out.printf("%s  -  %.0f%n", cr.matriculaAluno(), cr.alunoCR()));
        
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("----- Média de CR dos cursos ------");
        
        List<CRCursoDTO> crsCursos = cursoService.listarCRdoCursoEmDTO();
        crsCursos.stream()
                .sorted((a, b) -> a.codigoCurso().compareTo(b.codigoCurso()))
                .forEach(cr -> System.out.printf("%s   -  %.0f%n", cr.codigoCurso(), cr.mediaCR()));
        
        System.out.println("-----------------------------------");
    }
}