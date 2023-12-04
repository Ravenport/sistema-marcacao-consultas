package br.edu.infnet.repository;

import br.edu.infnet.model.domain.Pedido;
import org.springframework.data.repository.ListCrudRepository;

public interface PedidoRepository extends ListCrudRepository<Pedido, Integer> {
}
