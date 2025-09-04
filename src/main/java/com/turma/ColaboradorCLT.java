package com.turma;

public class ColaboradorCLT extends Pessoa {
    private double salarioBase;
    private double horasExtras;
    private double valorHoraExtra;

    public ColaboradorCLT(String nome, int idade, double salarioBase) {
        super(nome, idade);
        this.salarioBase = salarioBase;
        this.horasExtras = 0.0;
        this.valorHoraExtra = salarioBase / 220.0 * 1.5; // 50% a mais sobre valor hora normal
    }

    public ColaboradorCLT(String nome, int idade, double salarioBase, double horasExtras) {
        super(nome, idade);
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        this.valorHoraExtra = salarioBase / 220.0 * 1.5; // 50% a mais sobre valor hora normal
    }

    @Override
    public String getTipo() {
        return "CLT";
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasExtras * valorHoraExtra);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
        this.valorHoraExtra = salarioBase / 220.0 * 1.5;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    @Override
    public String toString() {
        return "ColaboradorCLT{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salarioBase=" + salarioBase +
                ", horasExtras=" + horasExtras +
                ", salarioTotal=" + calcularSalario() +
                '}';
    }
}