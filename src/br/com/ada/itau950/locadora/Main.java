package br.com.ada.itau950.locadora;

import br.com.ada.itau950.locadora.entidades.Locacao;
import br.com.ada.itau950.locadora.entidades.Locadora;
import br.com.ada.itau950.locadora.entidades.PessoaFisica;
import br.com.ada.itau950.locadora.entidades.Veiculo;
import br.com.ada.itau950.locadora.service.VeiculoService;
import br.com.ada.itau950.locadora.service.email.EmailFormatarMiniscula;
import br.com.ada.itau950.locadora.service.email.EmailServiceImpl;
import br.com.ada.itau950.locadora.service.email.EnvioEmailService;
import br.com.ada.itau950.locadora.service.impl.LocacaoServiceImpl;
import br.com.ada.itau950.locadora.service.impl.VeiculoServiceImpl;
import br.com.ada.itau950.locadora.service.email.EmailFormatarMaiuscula;
import br.com.ada.itau950.locadora.service.validation.locacao.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new Main().start();

    }

    private void start() {

        VeiculoService veiculoService = new VeiculoServiceImpl();

        System.out.println("Bem vindo - Locadora de Veiculos");


        //solicitar dados do cliente PF/PJ, endereco

        Map<String, Veiculo> veiculosMap = veiculoService.recuperarVeiculoArquivo();

        /*System.out.println("Veiculos disponiveis:");

        //listar veiculos

        System.out.println("Digite a placa do veiculo:");
        String placa = scanner.next();

        System.out.println("Data locaçao:");
        String dataLocacao = scanner.next();

        System.out.println("Data devoluçao:");
        String dataDevolucao = scanner.next();*/

        List<LocacaoValidacao> validacaosList = new ArrayList<>();
        validacaosList.add(new LocacaoDatasValidacao());
        validacaosList.add(new LocacaoClienteIdadeValidacao());
        validacaosList.add(new LocacaoClienteDocumentoValidacao());
        validacaosList.add(new LocacaoVeiculoOnibusIdadeValidacao());

        EnvioEmailService envioEmailService = new EmailFormatarMiniscula(new EmailFormatarMaiuscula(new EmailServiceImpl()));

        LocacaoServiceImpl locacaoService = new LocacaoServiceImpl(validacaosList, envioEmailService);

        PessoaFisica cliente = new PessoaFisica();
        cliente.setCpf("12345");
        cliente.setNome("Rodrigo");
        cliente.setDataNascimento(LocalDate.of(1984, 6, 19));
        cliente.setEmail("rodrigo@email.com");

        Locacao locacao = new Locacao(
                cliente,
                veiculosMap.get("SPR1234"),
                LocalDateTime.now(),
                LocalDate.of(2022, 11, 28).atStartOfDay()
        );


        List<String> erros = locacaoService.salvarLocacao(locacao);

        System.out.println("Sucesso ? " + erros.isEmpty());

        erros.forEach(msg -> System.err.println(msg));




        //1 - calcular o valor da locacao
        //2 - pedir para o cliente confirmar, se sim finalizar a locacao

        /*try {
            locacaoService.salvarLocacao(locacao);
        } catch (ValidacaoException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }*/

    }

}