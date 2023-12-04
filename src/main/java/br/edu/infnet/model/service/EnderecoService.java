package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.model.domain.Profissional;
import br.edu.infnet.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void Incluir(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Collection<Endereco> obterLista() {
        return enderecoRepository.findAll();
    }
}
