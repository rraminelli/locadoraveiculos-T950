package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.util.Map;

public interface VeiculoService {

    Map<String, Veiculo> recuperarVeiculoArquivo();

    Map<String, Veiculo> recuperarVeiculoBancoDados();

    void calcularSeguroObrigatorio(Veiculo veiculo);

    void calcularSeguroRoubo(Veiculo veiculo);

}
