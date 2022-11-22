package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.math.BigDecimal;

public class MotoPortoSeguroSeguroService implements SeguroTotalService {

    @Override
    public BigDecimal calcularSeguroObrigatorio(Veiculo veiculo) {
        return new BigDecimal(85);
    }

    @Override
    public BigDecimal calcularSeguroRoubo(Veiculo veiculo) {
        return new BigDecimal(180);
    }

}
