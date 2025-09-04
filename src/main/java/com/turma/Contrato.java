package com.turma;

public class Contrato implements Remuneracao {
    private float salario;

    public Contrato(float salario) {
        this.salario = salario;
    }

    @Override
    public float calcularValor() {
        return salario();
    }

    public float salario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "salario=" + salario +
                '}';
    }
}