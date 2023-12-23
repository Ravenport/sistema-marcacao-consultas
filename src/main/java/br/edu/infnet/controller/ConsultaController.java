package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.Consulta;
import br.edu.infnet.model.service.ClienteService;
import br.edu.infnet.model.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @GetMapping(value = "/listar")
    public List<Consulta> obterLista() {
        return (List<Consulta>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Consulta consulta) {
        service.Incluir(consulta);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
