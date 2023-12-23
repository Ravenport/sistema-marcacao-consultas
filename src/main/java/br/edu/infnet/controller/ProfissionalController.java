package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.model.service.PedidoService;
import br.edu.infnet.model.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional/")
public class ProfissionalController {
    @Autowired
    private ProfissionalService service;

    @GetMapping(value = "/listar")
    public List<Profissional> obterLista() {
        return (List<Profissional>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Profissional profissional) {
        service.Incluir(profissional);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
