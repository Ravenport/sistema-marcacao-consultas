package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.ConsultaFisicaService;
import br.edu.infnet.model.service.ConsultaRemotaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Component
@Order(6)
public class ConsultaFisicaLoader implements ApplicationRunner {
    ConsultaFisicaService service = new ConsultaFisicaService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Leitura do arquivo text

        FileReader file = new FileReader("files/consultasfisicas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Profissional profissional = new Profissional();
            profissional.setId(Integer.valueOf(campos[3]));

            Endereco endereco = new Endereco();
            endereco.setId(Integer.valueOf(campos[4]));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(campos[5]));

            ConsultaFisica consulta = new ConsultaFisica();

            consulta.setEndereco(endereco);
            consulta.setProfissional(profissional);
            consulta.setHorario(LocalDateTime.parse(campos[1]));
            consulta.setCliente(cliente);

            service.Incluir(consulta);
            linha = leitura.readLine();
        }

        for (Consulta consultaLida : service.obterLista()) {
            System.out.println("[Consulta Fisica]: " + consultaLida);
        }
        leitura.close();
    }
}

