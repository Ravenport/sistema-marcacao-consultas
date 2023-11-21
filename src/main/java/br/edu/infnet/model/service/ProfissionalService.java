package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Profissional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfissionalService {
    private Map<String, Profissional> map = new HashMap<>();

    public void Incluir(Profissional profissional) {
        map.put(profissional.getCnpj(), profissional);
    }

    public Collection<Profissional> obterLista() {
        return map.values();
    }
}
