package br.com.ada.itau950.locadora.service.validation.pessoa;

import br.com.ada.itau950.locadora.entidades.PessoaFisica;

public class ValidarPessoaFisica implements ValidarPessoa<PessoaFisica> {

    @Override
    public void validarDocumento(PessoaFisica pessoa) {
        pessoa.getCpf();
        //validar cpf
    }

}
