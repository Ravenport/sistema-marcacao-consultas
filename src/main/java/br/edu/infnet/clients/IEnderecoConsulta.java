package br.edu.infnet.clients;

import br.edu.infnet.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoConsulta")
public interface IEnderecoConsulta {

    @GetMapping(value = "/{cep}/json/")
    public Endereco buscarCep(@PathVariable String cep);
}
