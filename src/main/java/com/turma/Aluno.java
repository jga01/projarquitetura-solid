package com.turma;

public class Aluno extends Pessoa {
    private float nota;

    public Aluno(String nome, int idade, float nota) {
        super(nome, idade);
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }

    @Override
    public double calcularSalario() {
        return 0.0; // Alunos não recebem salário
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nota=" + nota +
                '}';
    }
}