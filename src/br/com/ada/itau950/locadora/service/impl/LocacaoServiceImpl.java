package br.com.ada.itau950.locadora.service.impl;

import br.com.ada.itau950.locadora.dto.EmailDto;
import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.exceptions.ValidacaoException;
import br.com.ada.itau950.locadora.repository.LocacaoRepository;
import br.com.ada.itau950.locadora.service.email.EnvioEmailService;
import br.com.ada.itau950.locadora.service.validation.locacao.LocacaoValidacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LocacaoServiceImpl {

    LocacaoRepository locacaoRepository = new LocacaoRepository();

    List<LocacaoValidacao> validacoesList;
    EnvioEmailService emailService;

    public LocacaoServiceImpl(List<LocacaoValidacao> validacoesList, EnvioEmailService emailService) {
        this.validacoesList = validacoesList;
        this.emailService = emailService;
    }

    public List<String> salvarLocacao(final Locacao locacao) {

        List<String> erros = new ArrayList<>();

        validacoesList.stream().parallel().forEach(locacaoValidacao -> {
            try {
                locacaoValidacao.validar(locacao);
            } catch (ValidacaoException e) {
                System.out.println("Erro:" + e.getMessage());
                erros.add(e.getMessage());
                //throw new RuntimeException(e.getMessage());
            }
        });

        //tem o seguro obrigatorio pago
        //validar o cartao de credito

        //salvar no banco de dados
        if (erros.isEmpty()) {
            locacaoRepository.salvarLocacao(locacao);

            //enviar um email para o cliente
            EmailDto emailDto = new EmailDto();
            emailDto.setNome(locacao.getCliente().getNome());
            emailDto.setEmailDestinatario(locacao.getCliente().getEmail());
            emailDto.setMensagem("Dados da locacao");
            emailDto.setAssunto("Assunto");
            emailService.enviarEmail(emailDto);
        }

        return erros;

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
