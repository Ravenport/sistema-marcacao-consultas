package br.edu.infnet.model.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
public class ConsultaFisica extends Consulta{
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Override
    public String toString() {
        return super.toString() + ", endereço= " + getEndereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
