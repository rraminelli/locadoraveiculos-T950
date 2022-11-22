package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.CarroPasseio;
import br.com.ada.itau950.locadora.entidades.Motocicleta;
import br.com.ada.itau950.locadora.entidades.Onibus;
import br.com.ada.itau950.locadora.entidades.Veiculo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VeiculoService {

    private SeguroRouboService<CarroPasseio> carroPasseioSeguroRouboService = new CarroPasseioSeguroService();
    private SeguroTotalService onibusSeguroService = new OnibusSeguroService();

    private SeguroTotalService<Motocicleta> motoSeguroService = new MotoPortoSeguroSeguroService();


    public Map<String, Veiculo> recuperarVeiculoArquivo() {

        Map<String, Veiculo> veiculos = new HashMap<>();

        var fiatUno = new CarroPasseio();
        BigDecimal fiatUnoSeguroRoubo = carroPasseioSeguroRouboService.calcularSeguroRoubo(fiatUno);
        fiatUno.setSeguroRoubo(fiatUnoSeguroRoubo);
        fiatUno.setMarca("Fiat");
        fiatUno.setModelo("Uno");
        fiatUno.setAno(2021);
        fiatUno.setPlaca("ABC1234");
        fiatUno.setValorDiariaLocacao(new BigDecimal(80));

        veiculos.put(fiatUno.getPlaca(), fiatUno);

        Motocicleta hondaCG = new Motocicleta();
        BigDecimal hondaCGSeguroObrigatorio = motoSeguroService.calcularSeguroObrigatorio(hondaCG);
        BigDecimal hondaCGSeguroRoubo = motoSeguroService.calcularSeguroRoubo(hondaCG);
        hondaCG.setSeguroRoubo(hondaCGSeguroRoubo);
        hondaCG.setSeguroObrigatorio(hondaCGSeguroObrigatorio);
        hondaCG.setMarca("Honda");
        hondaCG.setModelo("CG");
        hondaCG.setAno(2022);
        hondaCG.setPlaca("MOT1234");
        hondaCG.setValorDiariaLocacao(new BigDecimal(40));

        veiculos.put(hondaCG.getPlaca(), hondaCG);

        Veiculo onibus = new Onibus();
        BigDecimal mercedesSprinterSeguroObrigatorio = onibusSeguroService.calcularSeguroObrigatorio(onibus);
        BigDecimal mercedesSprinterSeguroRoubo = onibusSeguroService.calcularSeguroObrigatorio(onibus);
        onibus.setSeguroObrigatorio(mercedesSprinterSeguroObrigatorio);
        onibus.setSeguroRoubo(mercedesSprinterSeguroRoubo);
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

}
