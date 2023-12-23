package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.DiasDisponiveis;
import br.edu.infnet.repository.DiasDisponiveisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DiasDisponiveisService {

    @Autowired
    private DiasDisponiveisRepository diasDisponiveisRepository;

    public void Incluir(DiasDisponiveis dias) {
        diasDisponiveisRepository.save(dias);
    }

    public Collection<DiasDisponiveis> obterLista() {
        return (Collection<DiasDisponiveis>) diasDisponiveisRepository.findAll();
    }

    public void excluir(Integer id) {
        diasDisponiveisRepository.deleteById(id);
    }
}
