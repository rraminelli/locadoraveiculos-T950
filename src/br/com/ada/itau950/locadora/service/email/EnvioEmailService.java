package br.com.ada.itau950.locadora.service.email;

import br.com.ada.itau950.locadora.dto.EmailDto;

public interface EnvioEmailService {

    void enviarEmail(EmailDto email);

}
