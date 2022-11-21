package br.com.ada.itau950.locadora.exemplo;

import java.math.BigDecimal;

public class Professor {
    private String nome;

    private boolean emTreinamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEmTreinamento() {
        return emTreinamento;
    }

    public void setEmTreinamento(boolean emTreinamento) {
        this.emTreinamento = emTreinamento;
    }
}