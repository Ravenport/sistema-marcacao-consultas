package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void Incluir(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista() {
        return pedidoRepository.findAll();
    }
}
