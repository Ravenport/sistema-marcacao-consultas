package br.edu.infnet.model.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String formaPag;
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Consulta> consultas;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedido;

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

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Pedido> getPedido() {
        return pedido;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}
