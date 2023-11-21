package br.edu.infnet.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Consulta {
    private Profissional profissional;
    private Cliente cliente;
    private LocalDateTime horario;

    @Override
    public String toString() {
        return "Consulta{" +
                "profissional=" + profissional +
                ", cliente=" + cliente +
                ", horario=" + horario +
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
}
