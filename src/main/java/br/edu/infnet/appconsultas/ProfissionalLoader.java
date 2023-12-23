package br.edu.infnet.appconsultas;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.model.domain.HorasDisponiveis;
import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.model.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(1)
public class ProfissionalLoader implements ApplicationRunner {

    @Autowired
    private ProfissionalService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/profissionais.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Profissional profissional = new Profissional();
            profissional.setNome(campos[0]);
            profissional.setDescricao(campos[1]);
            profissional.setCnpj(campos[2]);
            profissional.setValorConsulta(Float.parseFloat(campos[3]));
            service.Incluir(profissional);

            linha = leitura.readLine();
        }

        for (Profissional profissional: service.obterLista()) {
            System.out.println("[Profissional]: " + profissional);
        }
        leitura.close();
    }
}
