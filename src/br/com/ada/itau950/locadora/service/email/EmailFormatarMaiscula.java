package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public class EmailFormatarMaiscula implements EnvioEmailService {

    EmailService emailService;

    public EmailFormatarMaiscula(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void enviarEmail(EmailDto email) {
        email.setMensagem(email.getMensagem().toUpperCase());
        emailService.enviarEmail(email);
    }

}
