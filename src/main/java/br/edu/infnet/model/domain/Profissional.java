package br.edu.infnet.model.domain;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Profissional {
    private String nome;
    private String descricao;
    private String cnpj;
    private float valorConsulta;
    private List<LocalDate> datasDisponiveis = new ArrayList<>();
    private List<LocalTime> horasDisponiveis = new ArrayList<>();

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

    public float getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
    public List<LocalDate> getDatasDisponiveis() {
        return datasDisponiveis;
    }
    public void setDatasDisponiveis(String datasDisponiveis) {
        this.datasDisponiveis.add(LocalDate.parse(datasDisponiveis));
    }
    public List<LocalTime> getHorasDisponiveis() {
        return horasDisponiveis;
    }
    public void setHorasDisponiveis(String horasDisponiveis) {
        this.horasDisponiveis.add(LocalTime.parse(horasDisponiveis));
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
}
