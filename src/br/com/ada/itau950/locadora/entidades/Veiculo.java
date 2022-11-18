package br.com.ada.itau950.locadora.entidades;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Veiculo {

    private String marca;
    private String modelo;
    private Integer ano;

    private String placa;

    private BigDecimal valorDiariaLocacao;


    public Map<String, Veiculo> recuperarVeiculoArquivo() {

        Map<String, Veiculo> veiculos = new HashMap<>();

        Veiculo fiatUno = new CarroPasseio();
        fiatUno.setMarca("Fiat");
        fiatUno.setModelo("Uno");
        fiatUno.setAno(2021);
        fiatUno.setPlaca("ABC1234");
        fiatUno.setValorDiariaLocacao(new BigDecimal(80));

        veiculos.put(fiatUno.getPlaca(), fiatUno);

        Veiculo hondaCG = new Motocicleta();
        hondaCG.setMarca("Honda");
        hondaCG.setModelo("CG");
        hondaCG.setAno(2022);
        hondaCG.setPlaca("MOT1234");
        hondaCG.setValorDiariaLocacao(new BigDecimal(40));

        veiculos.put(hondaCG.getPlaca(), hondaCG);

        Veiculo onibus = new Onibus();
        onibus.setMarca("Mercedes");
        onibus.setModelo("Sprinter 616");
        onibus.setAno(2022);
        onibus.setPlaca("SPR1234");
        onibus.setValorDiariaLocacao(new BigDecimal(140));

        veiculos.put(onibus.getPlaca(), onibus);

        return veiculos;
    }

    public Map<String, Veiculo> recuperarVeiculoBancoDados() {
        //realizar conexao banco de dados
        //ler os dados e devolver um Map
        return new HashMap<>();
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getValorDiariaLocacao() {
        return valorDiariaLocacao;
    }

    public void setValorDiariaLocacao(BigDecimal valorDiariaLocacao) {
        this.valorDiariaLocacao = valorDiariaLocacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
