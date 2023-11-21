package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.service.ClienteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClienteLoader implements ApplicationRunner {

    private ClienteService service = new ClienteService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Leitura do arquivo text

        FileReader file =  new FileReader("files/clientes.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Cliente cliente = new Cliente();
            cliente.setNome(campos[0]);
            cliente.setCpf(campos[1]);
            cliente.setEmail(campos[2]);
            cliente.setTelefone(campos[3]);
            cliente.setFormaPag(campos[4]);
            cliente.setDataNascimento(campos[5]);

            service.Incluir(cliente);

            linha = leitura.readLine();
        }

        for(Cliente cliente: service.obterLista()) {
            System.out.println("[CLIENTE]: " + cliente);
        }
        leitura.close();
    }
}
