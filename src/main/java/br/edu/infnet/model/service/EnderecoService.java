package br.edu.infnet.model.service;

import br.edu.infnet.clients.IEnderecoConsulta;
import br.edu.infnet.model.domain.Endereco;
import br.edu.infnet.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private IEnderecoConsulta enderecoConsulta;

    public void Incluir(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Collection<Endereco> obterLista() {
        return (Collection<Endereco>) enderecoRepository.findAll();
    }

    public Endereco buscarCep(String cep) {
        return enderecoConsulta.buscarCep(cep);
    }

    public void excluir(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
