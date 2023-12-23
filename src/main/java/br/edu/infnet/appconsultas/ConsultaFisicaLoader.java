package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.ConsultaFisicaService;
import br.edu.infnet.model.service.ConsultaRemotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Component
@Order(8)
public class ConsultaFisicaLoader implements ApplicationRunner {
    @Autowired
    ConsultaFisicaService service;

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

            DiasDisponiveis diasDisponiveis = new DiasDisponiveis();
            diasDisponiveis.setId(Integer.valueOf(campos[1]).intValue());

            Pedido pedido = new Pedido();
            pedido.setId(Integer.valueOf(campos[6]));

            HorasDisponiveis horasDisponiveis = new HorasDisponiveis();
            horasDisponiveis.setId(Integer.valueOf(campos[2]));

            Endereco endereco = new Endereco();
            endereco.setId(Integer.valueOf(campos[4]));

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(campos[5]));

            ConsultaFisica consulta = new ConsultaFisica();
            consulta.setId(Integer.valueOf(campos[7]));
            consulta.setEndereco(endereco);
            consulta.setProfissional(profissional);
            consulta.setHorario(horasDisponiveis);
            consulta.setDia(diasDisponiveis);
            consulta.setCliente(cliente);
            consulta.setPedido(pedido);

            service.Incluir(consulta);
            linha = leitura.readLine();
        }

        for (Consulta consultaLida : service.obterLista()) {
            System.out.println("[Consulta Fisica]: " + consultaLida);
        }
        leitura.close();
    }
}

