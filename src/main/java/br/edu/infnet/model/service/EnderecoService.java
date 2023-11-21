package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.domain.Profissional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnderecoService {

    private Map<String, Endereco> map = new HashMap<>();

    public void Incluir(Endereco endereco) {
        map.put(endereco.getCep() + " - " + endereco.getNumero(), endereco);
    }

    public Collection<Endereco> obterLista() {
        return map.values();
    }
}
