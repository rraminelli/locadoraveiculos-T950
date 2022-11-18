package br.com.ada.itau950.locadora.service.validation;

import br.com.ada.itau950.locadora.entidades.PessoaJurica;

public class ValidarPessoaJuridica implements ValidarPessoa<PessoaJurica> {

    @Override
    public void validarDocumento(PessoaJurica pessoa) {
        pessoa.getCnpj();
        //validar cnpj
    }

}
