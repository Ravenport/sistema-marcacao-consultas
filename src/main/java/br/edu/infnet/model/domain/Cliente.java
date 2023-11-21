package br.edu.infnet.model.domain;

import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String formaPag;
    private LocalDate dataNascimento;

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", formaPag='" + getFormaPag() + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public void setDataNascimento(String data) {
        dataNascimento = LocalDate.parse(data);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }
}
