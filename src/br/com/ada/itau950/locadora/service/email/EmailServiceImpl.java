package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public class EmailServiceImpl implements EnvioEmailService {

    EmailService emailService = new EmailService();

    @Override
    public void enviarEmail(EmailDto email) {
        emailService.enviarEmail(email);
    }

}
