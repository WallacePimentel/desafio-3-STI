package com.wallacepimentel.desafio3.controller;

import com.wallacepimentel.desafio3.DTO.CRCursoDTO;
import com.wallacepimentel.desafio3.service.CursoService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CRCursoController {

    private final CursoService cursoService;

    public CRCursoController (CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public List<CRCursoDTO> listarCRdoCurso () {
        return this.cursoService.listarCRdoCursoEmDTO();
    }
}
