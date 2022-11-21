package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.math.BigDecimal;

public class OnibusSeguroService implements SeguroTotalService {
    @Override
    public BigDecimal calcularSeguroObrigatorio(Veiculo veiculo) {
        if (veiculo.getAno() > 2019) {
            return new BigDecimal(250);
        } else {
            return new BigDecimal(150);
        }
    }

    @Override
    public BigDecimal calcularSeguroRoubo(Veiculo veiculo) {
        if (veiculo.getAno() > 2019) {
            return new BigDecimal(250);
        } else {
            return new BigDecimal(150);
        }
    }
}
