package br.edu.infnet.controller;

import br.edu.infnet.model.domain.ConsultaRemota;
import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.service.ConsultaRemotaService;
import br.edu.infnet.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido/")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping(value = "/listar")
    public List<Pedido> obterLista() {
        return (List<Pedido>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Pedido pedido) {
        service.Incluir(pedido);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
