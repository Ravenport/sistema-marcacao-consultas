package br.edu.infnet.model.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private Boolean consultaConfirmada;
    private List<Consulta> formaReserva;

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", consultaConfirmada=" + consultaConfirmada +
                ", formaReserva=" + formaReserva +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isConsultaConfirmada() {
        return consultaConfirmada;
    }

    public void setConsultaConfirmada(boolean consultaConfirmada) {
        this.consultaConfirmada = consultaConfirmada;
    }

    public List<Consulta> getFormaReserva() {
        return formaReserva;
    }

    public void setFormaReserva(List<Consulta> formaReserva) {
        this.formaReserva = formaReserva;
    }
}
