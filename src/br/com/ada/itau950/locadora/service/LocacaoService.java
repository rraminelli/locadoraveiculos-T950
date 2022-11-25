package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.entidades.Locacao;

import java.math.BigDecimal;
import java.util.List;

public interface LocacaoService {

    List<String> salvarLocacao(final Locacao locacao);

    Locacao recuperarLocacao(Long idLocacao);

    BigDecimal calcularTotalLocacao(Locacao locacao);

}
