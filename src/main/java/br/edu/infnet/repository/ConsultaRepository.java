package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Consulta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
}
