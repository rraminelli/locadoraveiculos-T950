package br.com.ada.itau950.locadora.service.validation.locacao;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;

public class LocacaoDatasValidacao implements LocacaoValidacao {

    @Override
    public void validar(Locacao locacao) throws ValidacaoException {

        if (locacao.getDataHoraLocacao().isAfter(locacao.getDataHoraDevolucao())) {
            throw new ValidacaoException("Data de locaçao nao pode ser maior que a data de devoluçao.");
        }

    }

}
