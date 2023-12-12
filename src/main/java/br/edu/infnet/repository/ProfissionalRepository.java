package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Profissional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends CrudRepository<Profissional, Integer> {
}
