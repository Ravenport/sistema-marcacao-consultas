package br.edu.infnet.model.domain;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    private String cnpj;
    private float valorConsulta;

    @OneToMany
    @JoinColumn(name = "consulta_id")
    private List<Consulta> consultas;

    @OneToMany
    @JoinColumn(name = "dia_id")
    private List<DiasDisponiveis> datasDisponiveis;
    @OneToMany
    @JoinColumn(name = "hora_id")
    private List<HorasDisponiveis> horasDisponiveis;

    @Override
    public String toString() {
        return "Profissional{" +
                "nome='" + getNome() + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", valorConsulta='" + getValorConsulta() + '\'' +
                ", datasDisponiveis='" + getDatasDisponiveis() + '\'' +
                ", horasDisponiveis=" + getHorasDisponiveis() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<DiasDisponiveis> getDatasDisponiveis() {
        return datasDisponiveis;
    }

    public void setDatasDisponiveis(List<DiasDisponiveis> datasDisponiveis) {
        this.datasDisponiveis = datasDisponiveis;
    }

    public List<HorasDisponiveis> getHorasDisponiveis() {
        return horasDisponiveis;
    }

    public void setHorasDisponiveis(List<HorasDisponiveis> horasDisponiveis) {
        this.horasDisponiveis = horasDisponiveis;
    }
}
