package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.math.BigDecimal;

public interface SeguroObrigatorioService {

    BigDecimal calcularSeguroObrigatorio(Veiculo veiculo);

}
