package com.turma;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO PROJETO TURMA - APLICANDO SRP ===\n");

        Turma turma = new Turma("Turma de Java - 2024");

        Aluno aluno1 = new Aluno("João Silva", 20, 8.5f);
        Aluno aluno2 = new Aluno("Maria Santos", 19, 9.2f);
        Aluno aluno3 = new Aluno("Pedro Oliveira", 21, 7.8f);
        Aluno aluno4 = new Aluno("Ana Costa", 20, 9.5f);

        turma.add(aluno1);
        turma.add(aluno2);
        turma.add(aluno3);
        turma.add(aluno4);

        TurmaViewer viewer = new TurmaViewer(turma);
        
        System.out.println("1. Dados completos da turma:");
        viewer.imprimeDados();
        System.out.println();

        System.out.println("2. Dados resumidos da turma:");
        viewer.mostraDados();
        System.out.println();

        Repositorio repositorio = new Repositorio("turma_java_2024.txt");
        
        System.out.println("3. Salvando turma no repositório:");
        repositorio.save(turma);
        System.out.println();

        System.out.println("4. Carregando turma do repositório:");
        Turma turmaCarregada = repositorio.load();
        if (turmaCarregada != null) {
            TurmaViewer viewerCarregada = new TurmaViewer(turmaCarregada);
            viewerCarregada.mostraDados();
        }
        System.out.println();

        System.out.println("5. Adicionando novo aluno:");
        Aluno novoAluno = new Aluno("Carlos Pereira", 22, 8.7f);
        turma.add(novoAluno);
        viewer.mostraDados();
        System.out.println();

        System.out.println("6. Atualizando turma no repositório:");
        repositorio.update(turma);
        System.out.println();

        System.out.println("7. Removendo um aluno:");
        turma.delete(aluno1);
        viewer.mostraDados();
        System.out.println();

        System.out.println("=== DEMONSTRAÇÃO CONCLUÍDA ===");
        System.out.println("\nEste projeto demonstra a aplicação do SRP (Single Responsibility Principle):");
        System.out.println("- Turma: Responsável pela lógica de negócio (adicionar/remover alunos, calcular média)");
        System.out.println("- TurmaViewer: Responsável pela apresentação dos dados");
        System.out.println("- Repositorio: Responsável pela persistência de dados");
        System.out.println("- Aluno: Representa a entidade básica do domínio");
    }
}