package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.model.domain.HorasDisponiveis;
import br.edu.infnet.repository.DiasDisponiveisRepository;
import br.edu.infnet.repository.HorasDisponiveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HorasDisponiveisService {

    @Autowired
    private HorasDisponiveisRepository horasDisponiveisRepository;

    public void Incluir(HorasDisponiveis horas) {
        horasDisponiveisRepository.save(horas);
    }

    public Collection<HorasDisponiveis> obterLista() {
        return horasDisponiveisRepository.findAll();
    }
}
