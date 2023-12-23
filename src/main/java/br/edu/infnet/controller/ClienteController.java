package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.service.ClienteService;
import br.edu.infnet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/listar")
    public List<Cliente> obterLista() {
        return (List<Cliente>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Cliente cliente) {
        service.Incluir(cliente);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
