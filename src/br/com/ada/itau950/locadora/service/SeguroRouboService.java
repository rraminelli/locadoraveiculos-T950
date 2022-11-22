package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.*;

import java.math.BigDecimal;

public interface SeguroRouboService<T extends Veiculo> {

    BigDecimal calcularSeguroRoubo(T veiculo);

}
