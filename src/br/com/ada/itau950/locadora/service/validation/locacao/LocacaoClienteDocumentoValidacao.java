package br.com.ada.itau950.locadora.service.validation.locacao;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.entidades.PessoaFisica;
import br.com.ada.itau950.locadora.service.validation.pessoa.ValidarPessoa;
import br.com.ada.itau950.locadora.service.validation.pessoa.ValidarPessoaFisica;
import br.com.ada.itau950.locadora.service.validation.pessoa.ValidarPessoaJuridica;

public class LocacaoClienteDocumentoValidacao implements LocacaoValidacao {

    @Override
    public void validar(Locacao locacao) {

        ValidarPessoa validarPessoa =
                (locacao.getCliente() instanceof PessoaFisica) ? new ValidarPessoaFisica() : new ValidarPessoaJuridica();
        validarPessoa.validarDocumento(locacao.getCliente());

    }

}
