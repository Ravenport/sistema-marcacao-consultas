package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.ConsultaRemotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(7)
public class ConsultaRemotaLoader implements ApplicationRunner {
    @Autowired
    ConsultaRemotaService service;

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

            DiasDisponiveis diasDisponiveis = new DiasDisponiveis();
            diasDisponiveis.setId(Integer.valueOf(campos[1]));

            Pedido pedido = new Pedido();
            pedido.setId(Integer.valueOf(campos[6]));

            HorasDisponiveis horasDisponiveis = new HorasDisponiveis();
            horasDisponiveis.setId(Integer.valueOf(campos[2]));

            Profissional profissional = new Profissional();
            profissional.setId(Integer.valueOf(campos[4]));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(campos[5]));

            consulta.setLink(campos[3]);
            consulta.setProfissional(profissional);
            consulta.setHorario(horasDisponiveis);
            consulta.setDia(diasDisponiveis);
            consulta.setCliente(cliente);
            consulta.setPedido(pedido);

            service.Incluir(consulta);
            linha = leitura.readLine();
        }

        for(Consulta consultaLida: service.obterLista()) {
            System.out.println("[Consulta Remota]: " + consultaLida);
        }
        leitura.close();
    }
}
