package com.wallacepimentel.desafio3.service;

import com.wallacepimentel.desafio3.model.MatriculaDisciplinaModel;
import com.wallacepimentel.desafio3.utils.Key;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MatriculaDisciplinaService {

    private final HashMap<Key, MatriculaDisciplinaModel> matriculasDeDisciplinas = new HashMap<>();

    public void adicionarMatriculaDisciplina (Key keyMatriculaDisciplina,
                                              MatriculaDisciplinaModel matriculaDisciplina) {
        this.matriculasDeDisciplinas.put(keyMatriculaDisciplina, matriculaDisciplina);
    }

    public boolean existeMatriculaDisciplina (Key keyMatriculaDisciplina) {
        return this.matriculasDeDisciplinas.containsKey(keyMatriculaDisciplina);
    }

    public MatriculaDisciplinaModel buscarMatriculaDisciplina (Key keyMatriculaDisciplina) {
        return this.matriculasDeDisciplinas.get(keyMatriculaDisciplina);
    }
}
