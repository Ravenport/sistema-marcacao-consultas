package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.service.EnderecoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(5)
public class EnderecoLoader implements ApplicationRunner {

    private EnderecoService service = new EnderecoService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/enderecos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Endereco endereco = new Endereco();
            endereco.setLogradouro(campos[0]);
            endereco.setTipoLogradouro(campos[1]);
            endereco.setCep(campos[2]);
            endereco.setNumero(campos[3]);
            endereco.setCidade(campos[4]);
            endereco.setEstado(campos[5]);
            endereco.setComplemento(campos[6]);

            service.Incluir(endereco);

            linha = leitura.readLine();
        }

        for (Endereco endereco: service.obterLista()) {
            System.out.println("[Endereco]: " + endereco);
        }
        leitura.close();
    }
}
