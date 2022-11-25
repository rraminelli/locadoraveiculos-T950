package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public class EmailFormatarMaiuscula implements EnvioEmailService {

    EnvioEmailService emailService;

    public EmailFormatarMaiuscula(EnvioEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void enviarEmail(EmailDto email) {
        email.setMensagem(email.getMensagem().toUpperCase());
        emailService.enviarEmail(email);
    }

}
