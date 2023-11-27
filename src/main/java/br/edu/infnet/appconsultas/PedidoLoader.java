package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.service.PedidoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoLoader implements ApplicationRunner {
    PedidoService service = new PedidoService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Leitura do arquivo text

        FileReader file =  new FileReader("files/pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;
        Profissional profissional = new Profissional();
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        List<Consulta> consultas = new ArrayList<>();

        while (linha != null) {
            campos = linha.split(";");

            switch (campos[0]) {
                case "Ped" -> {
                    Pedido pedido = new Pedido();

                    pedido.setCliente(cliente);
                    pedido.setConsultaConfirmada(Boolean.parseBoolean(campos[0]));
                    pedido.setFormaReserva(consultas);

                    service.Incluir(pedido);
                }
                case "ConF" -> {
                    ConsultaFisica consulta = new ConsultaFisica();

                    consulta.setEndereco(endereco);
                    consulta.setProfissional(profissional);
                    consulta.setHorario(LocalDateTime.parse(campos[1]));
                    consulta.setCliente(cliente);
                    consultas.add(consulta);

                    profissional = new Profissional();
                    endereco = new Endereco();
                }
                case "ConR" -> {
                    ConsultaRemota consulta = new ConsultaRemota();

                    consulta.setLink(campos[2]);
                    consulta.setProfissional(profissional);
                    consulta.setHorario(LocalDateTime.parse(campos[1]));
                    consulta.setCliente(cliente);
                    consultas.add(consulta);

                    profissional = new Profissional();
                }
                case "P" -> {
                    profissional.setNome(campos[1]);
                    profissional.setDescricao(campos[2]);
                    profissional.setCnpj(campos[3]);
                    profissional.setValorConsulta(Float.parseFloat(campos[4]));
                    profissional.setDatasDisponiveis(campos[5]);
                    profissional.setHorasDisponiveis(campos[6]);
                }
                case "C" -> {
                    cliente.setNome(campos[1]);
                    cliente.setCpf(campos[2]);
                    cliente.setEmail(campos[3]);
                    cliente.setTelefone(campos[4]);
                    cliente.setFormaPag(campos[5]);
                    cliente.setDataNascimento(campos[6]);
                }
                case "E" -> {
                    endereco.setLogradouro(campos[1]);
                    endereco.setTipoLogradouro(campos[2]);
                    endereco.setCep(campos[3]);
                    endereco.setNumero(campos[4]);
                    endereco.setCidade(campos[5]);
                    endereco.setEstado(campos[6]);
                    endereco.setComplemento(campos[7]);
                }
            }

            linha = leitura.readLine();
        }

        for(Pedido pedidoLido: service.obterLista()) {
            System.out.println("[Pedido]: " + pedidoLido);
        }
        leitura.close();
    }
}
