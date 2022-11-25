package br.com.ada.itau950.locadora.entidades;

import java.time.LocalDateTime;

public class Locadora {

    private PessoaJurica dadosPessoais;
    private LocalDateTime dataExpiracaoApp;

    public LocalDateTime getDataExpiracaoApp() {
        return dataExpiracaoApp;
    }

    public void setDataExpiracaoApp(LocalDateTime dataExpiracaoApp) {
        this.dataExpiracaoApp = dataExpiracaoApp;
    }

    public PessoaJurica getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(PessoaJurica dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }
}
