package com.turma;

import java.util.List;

public class TurmaViewer {
    private Turma turma;

    public TurmaViewer(Turma turma) {
        this.turma = turma;
    }

    public void imprimeDados() {
        System.out.println("=== DADOS DA TURMA ===");
        System.out.println("Nome da Turma: " + turma.getNome());
        System.out.println("Total de Alunos: " + turma.getTotalAlunos());
        System.out.printf("Média da Turma: %.2f%n", turma.calculaMedia());
        System.out.println();
        
        List<Aluno> alunos = turma.getAlunos();
        if (!alunos.isEmpty()) {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                System.out.printf("%d. %s (Idade: %d, Nota: %.2f)%n", 
                    i + 1, aluno.getNome(), aluno.getIdade(), aluno.getNota());
            }
        } else {
            System.out.println("Nenhum aluno cadastrado.");
        }
        System.out.println("=====================");
    }

    public void mostraDados() {
        System.out.println("Turma: " + turma.getNome());
        System.out.println("Alunos: " + turma.getTotalAlunos());
        System.out.printf("Média: %.2f%n", turma.calculaMedia());
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
