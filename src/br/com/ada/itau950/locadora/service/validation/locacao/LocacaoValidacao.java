package br.com.ada.itau950.locadora.service.validation.locacao;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;

public interface LocacaoValidacao {

    void validar(Locacao locacao) throws ValidacaoException;

}
