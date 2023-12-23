package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public void Incluir(Profissional profissional) {
        profissionalRepository.save(profissional);
    }

    public Collection<Profissional> obterLista() {
        return (Collection<Profissional>) profissionalRepository.findAll();
    }

    public void excluir(Integer id) {
        profissionalRepository.deleteById(id);
    }
}
