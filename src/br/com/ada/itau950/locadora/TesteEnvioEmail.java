package br.com.ada.itau950.locadora;

import br.com.ada.itau950.locadora.dto.EmailDto;
import br.com.ada.itau950.locadora.service.EmailService;

public class TesteEnvioEmail {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();

        EmailDto emailDto = new EmailDto();
        emailDto.setNome("Rodrigo");
        emailDto.setEmailDestinatario("rodrigo@email.com");
        emailDto.setAssunto("Nova locaçao");
        emailDto.setMensagem("Dados da locacao: Veiculo alugado: .... ");
        emailService.enviarEmail(emailDto);

    }

}
