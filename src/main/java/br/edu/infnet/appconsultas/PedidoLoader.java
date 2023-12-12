package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.PedidoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(8)
public class PedidoLoader implements ApplicationRunner {
    PedidoService service = new PedidoService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Leitura do arquivo text

        FileReader file =  new FileReader("files/pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");
            Pedido pedido = new Pedido();

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(campos[2]));

            Consulta consultas = new Consulta();
            consultas.setId(Integer.valueOf(campos[5]));

            pedido.setCliente(cliente);
            pedido.setConsultaConfirmada(Boolean.parseBoolean(campos[0]));
            pedido.setFormaReserva(consultas);

            service.Incluir(pedido);
            linha = leitura.readLine();
        }

        for(Pedido pedidoLido: service.obterLista()) {
            System.out.println("[Pedido]: " + pedidoLido);
        }
        leitura.close();
    }
}
