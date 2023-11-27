package br.edu.infnet.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consulta {
    private Profissional profissional;
    private Cliente cliente;
    private LocalDateTime horario;

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
}
