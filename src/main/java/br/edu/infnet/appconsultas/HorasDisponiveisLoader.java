package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.model.domain.HorasDisponiveis;
import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.model.service.HorasDisponiveisService;
import br.edu.infnet.model.service.ProfissionalService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;

@Component
@Order(2)
public class HorasDisponiveisLoader implements ApplicationRunner {

    private HorasDisponiveisService service = new HorasDisponiveisService();

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/horas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            HorasDisponiveis horasDisponiveis = new HorasDisponiveis();
            horasDisponiveis.setHora(LocalTime.parse(campos[0]));

            service.Incluir(horasDisponiveis);

            linha = leitura.readLine();
        }

        for (HorasDisponiveis horasDisponiveis: service.obterLista()) {
            System.out.println("[Horas Disponiveis]: " + horasDisponiveis);
        }
        leitura.close();
    }
}
