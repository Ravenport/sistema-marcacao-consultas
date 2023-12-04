package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Profissional;
import org.springframework.data.repository.ListCrudRepository;

public interface ProfissionalRepository extends ListCrudRepository<Profissional, Integer> {
}
