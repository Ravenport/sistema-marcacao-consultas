package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.ConsultaRemotaService;
import br.edu.infnet.repository.ProfissionalRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Component
@Order(7)
public class ConsultaRemotaLoader implements ApplicationRunner {
    ConsultaRemotaService service = new ConsultaRemotaService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Leitura do arquivo text

        FileReader file =  new FileReader("files/consultasremotas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            ConsultaRemota consulta = new ConsultaRemota();

            Profissional profissional = new Profissional();
            profissional.setId(Integer.valueOf(campos[3]));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(campos[4]));

            consulta.setLink(campos[2]);
            consulta.setProfissional(profissional);
            consulta.setHorario(LocalDateTime.parse(campos[1]));
            consulta.setCliente(cliente);

            service.Incluir(consulta);
            linha = leitura.readLine();
        }

        for(Consulta consultaLida: service.obterLista()) {
            System.out.println("[Consulta Remota]: " + consultaLida);
        }
        leitura.close();
    }
}
