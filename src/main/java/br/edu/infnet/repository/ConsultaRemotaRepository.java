package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Consulta;
import br.edu.infnet.model.domain.ConsultaRemota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRemotaRepository extends CrudRepository<ConsultaRemota, Integer> {
}
