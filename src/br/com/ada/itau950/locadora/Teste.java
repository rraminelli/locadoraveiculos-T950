package br.com.ada.itau950.locadora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Teste {

    public static void main(String[] args) {

        String formatacao = "2";

        System.out.printf("Valor: %."+ formatacao +"f", 200.203);

        NumberFormat numberFormat = new DecimalFormat("#0.0000");

        new BigDecimal("200.123").setScale(2, RoundingMode.CEILING);

    }

}
