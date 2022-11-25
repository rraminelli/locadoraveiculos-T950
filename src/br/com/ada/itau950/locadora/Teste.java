package br.com.ada.itau950.locadora;

import br.com.ada.itau950.locadora.entidades.Locadora;
import br.com.ada.itau950.locadora.entidades.PessoaJurica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Teste {

    public static void main(String[] args) {

        String formatacao = "2";

        System.out.printf("Valor: %."+ formatacao +"f", 200.203);

        NumberFormat numberFormat = new DecimalFormat("#0.0000");

        new BigDecimal("200.123").setScale(2, RoundingMode.CEILING);


        Locadora locadora = new Locadora();
        locadora.setDadosPessoais(new PessoaJurica());
        locadora.getDadosPessoais().setCnpj("1245");
        locadora.getDadosPessoais().setNome("Nome");
        locadora.getDadosPessoais().setEmail("email");
        locadora.setDataExpiracaoApp(LocalDateTime.now());


    }

}
