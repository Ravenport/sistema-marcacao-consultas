package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.ConsultaFisica;
import br.edu.infnet.repository.ConsultaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsultaFisicaService {

    @Autowired
    private ConsultaFisicaRepository consultaFisicaRepository;

    public void Incluir(ConsultaFisica consulta) {
        consultaFisicaRepository.save(consulta);
    }

    public Collection<ConsultaFisica> obterLista() {
        return (Collection<ConsultaFisica>) consultaFisicaRepository.findAll();
    }

    public void excluir(Integer id) {
        consultaFisicaRepository.deleteById(id);
    }
}
