package br.com.ada.itau950.locadora.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private Long idLocacao;
    private Pessoa cliente;
    private Veiculo veiculo;
    private LocalDateTime dataHoraLocacao;
    private LocalDateTime dataHoraDevolucao;

    public Locacao(Pessoa cliente, Veiculo veiculo, LocalDateTime dataHoraLocacao, LocalDateTime dataHoraDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataHoraLocacao = dataHoraLocacao;
        this.dataHoraDevolucao = dataHoraDevolucao;
    }


    public void salvarLocacao() {
        //validacoes (validar cpf, cnpj dataNasc)
        //data locacao menor que devolucao
        //salvar no banco de dados
        //enviar um email para o cliente
    }

    public void recuperarLocacao(Long idLocacao) {
        //buscar a locacao no banco de dados
    }

    public BigDecimal calcularTotalLocacao() {
        //calcular valor da locacao
        return BigDecimal.ZERO;
    }


    public Pessoa getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getDataHoraLocacao() {
        return dataHoraLocacao;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

}
