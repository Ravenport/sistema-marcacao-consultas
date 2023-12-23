package br.edu.infnet.controller;

import br.edu.infnet.model.domain.ConsultaFisica;
import br.edu.infnet.model.domain.ConsultaRemota;
import br.edu.infnet.model.service.ConsultaFisicaService;
import br.edu.infnet.model.service.ConsultaRemotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta-remota/")
public class ConsultaRemotaController {
    @Autowired
    private ConsultaRemotaService service;

    @GetMapping(value = "/listar")
    public List<ConsultaRemota> obterLista() {
        return (List<ConsultaRemota>) service.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody ConsultaRemota consulta) {
        service.Incluir(consulta);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
