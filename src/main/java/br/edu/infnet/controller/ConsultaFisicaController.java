package br.edu.infnet.controller;

import br.edu.infnet.model.domain.Consulta;
import br.edu.infnet.model.domain.ConsultaFisica;
import br.edu.infnet.model.service.ConsultaFisicaService;
import br.edu.infnet.model.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta-fisica/")
public class ConsultaFisicaController {
    @Autowired
    private ConsultaFisicaService service;

    @GetMapping(value = "/listar")
    public List<ConsultaFisica> obterLista() {
        return (List<ConsultaFisica>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody ConsultaFisica consulta) {
        service.Incluir(consulta);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
