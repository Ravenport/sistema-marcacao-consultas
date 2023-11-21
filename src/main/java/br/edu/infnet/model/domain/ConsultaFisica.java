package br.edu.infnet.model.domain;

public class ConsultaFisica extends Consulta{
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
