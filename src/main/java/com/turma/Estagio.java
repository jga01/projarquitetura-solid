package com.turma;

public class Estagio implements Remuneracao {
    private float bolsa;

    public Estagio(float bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public float calcularValor() {
        return bolsa();
    }

    public float bolsa() {
        return this.bolsa;
    }

    public void setBolsa(float bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public String toString() {
        return "Estagio{" +
                "bolsa=" + bolsa +
                '}';
    }
}