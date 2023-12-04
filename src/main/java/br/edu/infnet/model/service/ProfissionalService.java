package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public void Incluir(Profissional profissional) {
        profissionalRepository.save(profissional);
    }

    public Collection<Profissional> obterLista() {
        return profissionalRepository.findAll();
    }
}
