package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Consulta;
import br.edu.infnet.model.domain.ConsultaFisica;
import br.edu.infnet.repository.ConsultaFisicaRepository;
import br.edu.infnet.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public void Incluir(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public Collection<Consulta> obterLista() {
        return (Collection<Consulta>) consultaRepository.findAll();
    }

    public void excluir(Integer id) {
        consultaRepository.deleteById(id);
    }
}
