package br.edu.infnet.model.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Profissional profissional;
    @Transient
    private Cliente cliente;
    private LocalDateTime horario;

    @Transient
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/YYYY HH:mm:ss");
    @Override
    public String toString() {
        return "Consulta{" +
                "profissional= " + profissional +
                ", cliente= " + cliente +
                ", horario= " + horario.format(dtf) +
                '}';
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
