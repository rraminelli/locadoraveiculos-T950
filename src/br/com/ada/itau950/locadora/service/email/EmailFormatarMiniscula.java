package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public class EmailFormatarMiniscula implements EnvioEmailService {

    EnvioEmailService emailService;

    public EmailFormatarMiniscula(EnvioEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void enviarEmail(EmailDto email) {
        email.setMensagem(email.getMensagem().toLowerCase());
        emailService.enviarEmail(email);
    }

}
