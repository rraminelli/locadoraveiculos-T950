package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public final class EmailService {

    public void enviarEmail(EmailDto email) {

        //configurar o serviço de envio de email

        //implementacao envio email
        email.getEmailDestinatario();
        email.getNome();
        email.getMensagem();

        System.out.println("Enviando o email: " + email);

    }

}
