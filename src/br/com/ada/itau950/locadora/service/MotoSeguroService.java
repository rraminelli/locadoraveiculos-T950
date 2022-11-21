package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Motocicleta;
import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.math.BigDecimal;

public class MotoSeguroService implements SeguroTotalService<Motocicleta> {

    @Override
    public BigDecimal calcularSeguroObrigatorio(Motocicleta veiculo) {
        return new BigDecimal(50);
    }

    @Override
    public BigDecimal calcularSeguroRoubo(Motocicleta veiculo) {
        return new BigDecimal(125);
    }
}
