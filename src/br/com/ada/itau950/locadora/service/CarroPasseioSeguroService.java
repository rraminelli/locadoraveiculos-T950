package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.CarroPasseio;

import java.math.BigDecimal;

public class CarroPasseioSeguroService implements SeguroRouboService<CarroPasseio> {
    @Override
    public BigDecimal calcularSeguroRoubo(CarroPasseio veiculo) {
        return new BigDecimal(175);
    }
}
