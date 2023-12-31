package br.edu.infnet.repository;

import br.edu.infnet.model.domain.ConsultaFisica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaFisicaRepository extends CrudRepository<ConsultaFisica, Integer> {
}
