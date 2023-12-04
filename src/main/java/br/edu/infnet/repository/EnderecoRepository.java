package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Endereco;
import org.springframework.data.repository.ListCrudRepository;

public interface EnderecoRepository extends ListCrudRepository<Endereco, Integer> {
}
