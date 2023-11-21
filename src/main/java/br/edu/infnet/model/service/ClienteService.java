package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.Profissional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private Map <String, Cliente> mapa = new HashMap<>();

    public void Incluir(Cliente cliente) {
        mapa.put(cliente.getCpf(), cliente);
    }

    public Collection<Cliente> obterLista() {
        return mapa.values();
    }
}
