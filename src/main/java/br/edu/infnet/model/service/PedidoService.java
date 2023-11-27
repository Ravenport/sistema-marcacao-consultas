package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Pedido;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PedidoService {

    private Map<String, Pedido> map = new HashMap<>();

    public void Incluir(Pedido pedido) {
        map.put(pedido.getCliente().getCpf(), pedido);
    }

    public Collection<Pedido> obterLista() {
        return map.values();
    }
}
