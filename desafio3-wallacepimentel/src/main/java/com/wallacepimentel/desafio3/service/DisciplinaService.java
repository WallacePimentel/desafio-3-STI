package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.model.DisciplinaModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DisciplinaService {
    private final HashMap<String, DisciplinaModel> disciplinas = new HashMap<>();

    public void adicionarDisciplina(DisciplinaModel disciplina) {
        this.disciplinas.put(disciplina.getCodigoDisciplina(), disciplina);
    }

    public DisciplinaModel buscarDisciplinaPorCodigo (String codigoDisciplina) {
        return disciplinas.get(codigoDisciplina);
    }

    public boolean existeDisciplina (String codigoDisciplina) {
        return disciplinas.containsKey(codigoDisciplina);
    }
}
