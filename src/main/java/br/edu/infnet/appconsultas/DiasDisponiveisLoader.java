package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.model.service.DiasDisponiveisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

@Component
@Order(2)
public class DiasDisponiveisLoader implements ApplicationRunner {

    @Autowired
    private DiasDisponiveisService diasDisponiveisService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/dias.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Profissional profissional = new Profissional();
            profissional.setId(Integer.valueOf(campos[1]));

            DiasDisponiveis diasDisponiveis = new DiasDisponiveis();
            diasDisponiveis.setData(LocalDate.parse(campos[0]));
            diasDisponiveis.setProfissional(profissional);

            diasDisponiveisService.Incluir(diasDisponiveis);

            linha = leitura.readLine();
        }

        for (DiasDisponiveis diasDisponiveis: diasDisponiveisService.obterLista()) {
            System.out.println("[Dias Disponiveis]: " + diasDisponiveis);
        }
        leitura.close();
    }
}
