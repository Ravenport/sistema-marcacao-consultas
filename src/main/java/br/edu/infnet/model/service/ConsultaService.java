package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Consulta;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaService {
    private Map<String, Consulta> mapa = new HashMap<>();

    public void Incluir(Consulta consulta) {
        mapa.put(consulta.getProfissional().getCnpj(), consulta);
    }

    public Collection<Consulta> obterLista() {
        return mapa.values();
    }
}
