package com.wallacepimentel.desafio3.controller;

import com.wallacepimentel.desafio3.service.AlunoService;
import com.wallacepimentel.desafio3.service.CursoService;
import com.wallacepimentel.desafio3.utils.LeitorCSV;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//Pagina simples de exemplo sem usar mapping /cursos e /alunos para simplicidade
@Controller
public class SimpleWebController {

    private final LeitorCSV leitorCSV;
    private final AlunoService alunoService;
    private final CursoService cursoService;

    public SimpleWebController(LeitorCSV leitorCSV, AlunoService alunoService, CursoService cursoService) {
        this.leitorCSV = leitorCSV;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    @GetMapping("/")
    public String index(Model model) {

        leitorCSV.lerCSV();
        
        model.addAttribute("crsAlunos", alunoService.listarCRdosAlunosEmDTO());
        model.addAttribute("crsCursos", cursoService.listarCRdoCursoEmDTO());
        
        return "index";
    }
}