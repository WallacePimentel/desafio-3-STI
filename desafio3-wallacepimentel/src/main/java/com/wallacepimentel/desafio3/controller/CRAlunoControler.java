package com.wallacepimentel.desafio3.controller;

import com.wallacepimentel.desafio3.DTO.CRAlunoDTO;
import com.wallacepimentel.desafio3.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class CRAlunoControler {
    private final AlunoService alunoService;

    public CRAlunoControler (AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<CRAlunoDTO> listarCRdosAlunos () {
        return this.alunoService.listarCRdosAlunosEmDTO();
    }
}
