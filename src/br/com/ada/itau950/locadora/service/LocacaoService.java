package br.com.ada.itau950.locadora.service;

import br.com.ada.itau950.locadora.dto.EmailDto;
import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.entidades.PessoaFisica;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;
import br.com.ada.itau950.locadora.repository.LocacaoRepository;
import br.com.ada.itau950.locadora.service.validation.ValidarPessoa;
import br.com.ada.itau950.locadora.service.validation.ValidarPessoaFisica;
import br.com.ada.itau950.locadora.service.validation.ValidarPessoaJuridica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;

public class LocacaoService {

    LocacaoRepository locacaoRepository = new LocacaoRepository();

    public void salvarLocacao(Locacao locacao) throws ValidacaoException {

        ValidarPessoa validarPessoa =
                (locacao.getCliente() instanceof PessoaFisica) ? new ValidarPessoaFisica() : new ValidarPessoaJuridica();
        validarPessoa.validarDocumento(locacao.getCliente());

        //validacoes (validar cpf, cnpj, dataNasc)

        //data locacao menor que devolucao
        if (locacao.getDataHoraLocacao().isAfter(locacao.getDataHoraDevolucao())) {
            throw new ValidacaoException("Data de locaçao nao pode ser maior que a data de devoluçao.");
        }

        //salvar no banco de dados
        locacao = locacaoRepository.salvarLocacao(locacao);



        //enviar um email para o cliente
        EmailDto emailDto = new EmailDto();
        emailDto.setNome(locacao.getCliente().getNome());
        emailDto.setEmailDestinatario(locacao.getCliente().getEmail());
        emailDto.setMensagem("Dados da locacao");
        emailDto.setAssunto("Assunto");
        new EmailService().enviarEmail(emailDto);



    }

    public Locacao recuperarLocacao(Long idLocacao) {
        return locacaoRepository.recuperarLocacao(idLocacao);
    }

    public BigDecimal calcularTotalLocacao(Locacao locacao) {
        //calcular valor da locacao
        long horas = ChronoUnit.HOURS.between(locacao.getDataHoraLocacao(), locacao.getDataHoraDevolucao());

        BigDecimal dias = BigDecimal.valueOf(horas).divide(BigDecimal.valueOf(24), 0, RoundingMode.UP);

        BigDecimal valorTotal = locacao.getVeiculo().getValorDiariaLocacao().multiply(dias);

        return valorTotal;
    }

}
