package br.com.ada.itau950.locadora.service.validation.locacao;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.entidades.PessoaFisica;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocacaoClienteIdadeValidacao implements LocacaoValidacao {

    @Override
    public void validar(Locacao locacao) throws ValidacaoException {

        PessoaFisica pessoaFisica = (PessoaFisica) locacao.getCliente();

        long idade = ChronoUnit.YEARS.between(pessoaFisica.getDataNascimento(), LocalDate.now());

        if (idade < 18) {
            throw new ValidacaoException("Cliente deve ser maior de 18 anos");
        }

    }

}
