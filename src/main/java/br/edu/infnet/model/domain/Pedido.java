package br.edu.infnet.model.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Boolean consultaConfirmada;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
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

    public void setFormaReserva(Consulta formaReserva) {
        this.formaReserva.add(formaReserva);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
