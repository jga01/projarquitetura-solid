package com.turma;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private String nome;

    public Turma(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public float calculaMedia() {
        if (alunos.isEmpty()) {
            return 0.0f;
        }
        
        float soma = 0.0f;
        for (Aluno aluno : alunos) {
            soma += aluno.getNota();
        }
        return soma / alunos.size();
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public int getTotalAlunos() {
        return alunos.size();
    }

    public Aluno add(Aluno aluno) {
        if (aluno != null && !alunos.contains(aluno)) {
            alunos.add(aluno);
            return aluno;
        }
        return null;
    }

    public void delete(Aluno aluno) {
        alunos.remove(aluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}