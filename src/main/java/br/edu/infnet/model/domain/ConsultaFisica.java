package br.edu.infnet.model.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ConsultaFisica extends Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "endereço_id")
    private Endereco endereco;

    @Override
    public String toString() {
        return super.toString() + ", endereço= " + getEndereco();
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
