package br.com.ada.itau950.locadora.service.validation.locacao;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.entidades.Onibus;
import br.com.ada.itau950.locadora.entidades.PessoaFisica;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocacaoVeiculoOnibusIdadeValidacao implements LocacaoValidacao {


    @Override
    public void validar(Locacao locacao) throws ValidacaoException {

        if (locacao.getVeiculo() instanceof Onibus) {

            PessoaFisica pessoaFisica = (PessoaFisica) locacao.getCliente();

            long idade = ChronoUnit.YEARS.between(pessoaFisica.getDataNascimento(), LocalDate.now());

            if (idade < 21) {
                throw new ValidacaoException("Cliente deve ser maior de 21 anos");
            }

        }

    }

}
