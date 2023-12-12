package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.model.domain.HorasDisponiveis;
import br.edu.infnet.model.service.DiasDisponiveisService;
import br.edu.infnet.model.service.HorasDisponiveisService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
@Order(1)
public class DiasDisponiveisLoader implements ApplicationRunner {

    private DiasDisponiveisService service = new DiasDisponiveisService();
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/dias.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            DiasDisponiveis diasDisponiveis = new DiasDisponiveis();
            diasDisponiveis.setData(LocalDate.parse(campos[0]));

            service.Incluir(diasDisponiveis);

            linha = leitura.readLine();
        }

        for (DiasDisponiveis diasDisponiveis: service.obterLista()) {
            System.out.println("[Dias Disponiveis]: " + diasDisponiveis);
        }
        leitura.close();
    }
}
