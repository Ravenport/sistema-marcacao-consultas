package br.edu.infnet.model.service;

import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void Incluir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Collection<Cliente> obterLista() {
        return (Collection<Cliente>) clienteRepository.findAll();
    }

    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }
}
