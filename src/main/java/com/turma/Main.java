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

        System.out.println("8. Demonstrando o princípio OCP com novo colaborador CLT:");
        System.out.println("   (Aberto para extensão, fechado para modificação)\n");
        
        ColaboradorCLT colaborador1 = new ColaboradorCLT("Ana Silva", 30, 5000.0);
        ColaboradorCLT colaborador2 = new ColaboradorCLT("Roberto Santos", 35, 6000.0, 10.0);
        
        System.out.println("Colaboradores CLT criados:");
        System.out.println("- " + colaborador1);
        System.out.println("- " + colaborador2);
        System.out.println();
        
        System.out.println("Salários calculados:");
        System.out.println("- " + colaborador1.getNome() + ": R$ " + String.format("%.2f", colaborador1.calcularSalario()));
        System.out.println("- " + colaborador2.getNome() + ": R$ " + String.format("%.2f", colaborador2.calcularSalario()));
        System.out.println();

        System.out.println("=== DEMONSTRAÇÃO CONCLUÍDA ===");
        System.out.println("\nEste projeto demonstra a aplicação dos princípios SOLID:");
        System.out.println("- SRP: Cada classe tem uma única responsabilidade");
        System.out.println("  * Turma: Lógica de negócio (adicionar/remover alunos, calcular média)");
        System.out.println("  * TurmaViewer: Apresentação dos dados");
        System.out.println("  * Repositorio: Persistência de dados");
        System.out.println("- OCP: Sistema aberto para extensão, fechado para modificação");
        System.out.println("  * Pessoa: Classe base abstrata");
        System.out.println("  * Aluno: Extensão específica para estudantes");
        System.out.println("  * ColaboradorCLT: Nova extensão adicionada sem modificar código existente");
        System.out.println();

        System.out.println("9. Demonstrando OCP com Sistema de Folha de Pagamento:");
        System.out.println("   (Interface Remuneracao permite extensões sem modificar Folha)\n");

        // Criando a folha de pagamento
        Folha folha = new Folha();

        // Criando diferentes tipos de remuneração
        Contrato contrato1 = new Contrato(5000.0f);
        Contrato contrato2 = new Contrato(7500.0f);
        Estagio estagio1 = new Estagio(1200.0f);
        Estagio estagio2 = new Estagio(1500.0f);

        System.out.println("Remunerações criadas:");
        System.out.println("- " + contrato1 + " -> Valor: R$ " + contrato1.calcularValor());
        System.out.println("- " + contrato2 + " -> Valor: R$ " + contrato2.calcularValor());
        System.out.println("- " + estagio1 + " -> Valor: R$ " + estagio1.calcularValor());
        System.out.println("- " + estagio2 + " -> Valor: R$ " + estagio2.calcularValor());
        System.out.println();

        // Calculando a folha
        System.out.println("Processando folha de pagamento:");
        folha.calcular(contrato1);
        System.out.println("Adicionado contrato 1 -> Saldo atual: R$ " + folha.getSaldo());
        
        folha.calcular(contrato2);
        System.out.println("Adicionado contrato 2 -> Saldo atual: R$ " + folha.getSaldo());
        
        folha.calcular(estagio1);
        System.out.println("Adicionado estágio 1 -> Saldo atual: R$ " + folha.getSaldo());
        
        folha.calcular(estagio2);
        System.out.println("Adicionado estágio 2 -> Saldo atual: R$ " + folha.getSaldo());
        System.out.println();

        System.out.println("Resumo da folha:");
        System.out.println("- Total de remunerações: " + folha.getTotalRemuneracoes());
        System.out.println("- Saldo total: R$ " + String.format("%.2f", folha.getSaldo()));
        System.out.println();

        System.out.println("Benefícios do OCP aplicado:");
        System.out.println("- Interface Remuneracao define contrato comum");
        System.out.println("- Folha trabalha com qualquer implementação de Remuneracao");
        System.out.println("- Novos tipos (PJ, Freelancer, etc.) podem ser adicionados sem modificar Folha");
        System.out.println("- Sistema extensível e mantém compatibilidade");
    }
}