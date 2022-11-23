package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public class EmailFormatarMiniscula implements EnvioEmailService {

    EmailService emailService;

    public EmailFormatarMiniscula(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void enviarEmail(EmailDto email) {
        email.setMensagem(email.getMensagem().toLowerCase());
        emailService.enviarEmail(email);
    }

}
