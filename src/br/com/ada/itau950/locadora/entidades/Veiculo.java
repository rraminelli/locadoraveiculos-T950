package br.com.ada.itau950.locadora.entidades;

import java.math.BigDecimal;

public class Veiculo {

    private String marca;
    private String modelo;
    private Integer ano;
    private String placa;

    private BigDecimal valorDiariaLocacao;

    private BigDecimal seguroObrigatorio;

    private BigDecimal seguroRoubo;

    public BigDecimal getSeguroRoubo() {
        return seguroRoubo;
    }

    public void setSeguroRoubo(BigDecimal seguroRoubo) {
        this.seguroRoubo = seguroRoubo;
    }

    public BigDecimal getSeguroObrigatorio() {
        return seguroObrigatorio;
    }

    public void setSeguroObrigatorio(BigDecimal seguroObrigatorio) {
        this.seguroObrigatorio = seguroObrigatorio;
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
