package com.turma;

import java.util.ArrayList;
import java.util.List;

public class Folha {
    private float saldo;
    private List<Remuneracao> remuneracoes;

    public Folha() {
        this.saldo = 0.0f;
        this.remuneracoes = new ArrayList<>();
    }

    public void calcular(Remuneracao remuneracao) {
        if (remuneracao != null) {
            this.saldo += remuneracao.calcularValor();
            this.remuneracoes.add(remuneracao);
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public List<Remuneracao> getRemuneracoes() {
        return new ArrayList<>(remuneracoes);
    }

    public int getTotalRemuneracoes() {
        return remuneracoes.size();
    }

    public void zerarSaldo() {
        this.saldo = 0.0f;
        this.remuneracoes.clear();
    }

    @Override
    public String toString() {
        return "Folha{" +
                "saldo=" + saldo +
                ", totalRemuneracoes=" + remuneracoes.size() +
                '}';
    }
}