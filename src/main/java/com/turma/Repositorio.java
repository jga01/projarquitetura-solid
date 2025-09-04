package com.turma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private String filename;

    public Repositorio(String filename) {
        this.filename = filename;
    }

    public void save(Turma turma) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(turma.getNome());
            writer.println(turma.getTotalAlunos());
            
            for (Aluno aluno : turma.getAlunos()) {
                writer.println(aluno.getNome() + ";" + aluno.getIdade() + ";" + aluno.getNota());
            }
            
            System.out.println("Turma salva com sucesso em: " + filename);
        } catch (IOException e) {
            System.err.println("Erro ao salvar turma: " + e.getMessage());
        }
    }

    public Turma load() {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + filename);
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String nomeTurma = reader.readLine();
            if (nomeTurma == null) {
                System.err.println("Arquivo vazio ou corrompido");
                return null;
            }

            Turma turma = new Turma(nomeTurma);
            String totalAlunosStr = reader.readLine();
            
            if (totalAlunosStr != null) {
                int totalAlunos = Integer.parseInt(totalAlunosStr);
                
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length == 3) {
                        String nome = dados[0];
                        int idade = Integer.parseInt(dados[1]);
                        float nota = Float.parseFloat(dados[2]);
                        
                        Aluno aluno = new Aluno(nome, idade, nota);
                        turma.add(aluno);
                    }
                }
            }
            
            System.out.println("Turma carregada com sucesso de: " + filename);
            return turma;
            
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar turma: " + e.getMessage());
            return null;
        }
    }

    public void update(Turma turma) {
        save(turma);
        System.out.println("Turma atualizada com sucesso.");
    }

    public void delete() {
        File file = new File(filename);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Arquivo da turma deletado com sucesso: " + filename);
            } else {
                System.err.println("Erro ao deletar arquivo: " + filename);
            }
        } else {
            System.out.println("Arquivo não encontrado para deletar: " + filename);
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}