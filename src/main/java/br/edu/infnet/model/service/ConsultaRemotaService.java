package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.Consulta;
import br.edu.infnet.model.domain.ConsultaRemota;
import br.edu.infnet.repository.ConsultaFisicaRepository;
import br.edu.infnet.repository.ConsultaRemotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsultaRemotaService {
    @Autowired
    private ConsultaRemotaRepository consultaRemotaRepository;

    public void Incluir(ConsultaRemota consulta) {
        consultaRemotaRepository.save(consulta);
    }

    public Collection<ConsultaRemota> obterLista() {
        return (Collection<ConsultaRemota>) consultaRemotaRepository.findAll();
    }
}
