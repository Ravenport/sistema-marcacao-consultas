package br.edu.infnet.model.domain;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private HorasDisponiveis horario;

    @ManyToOne
    @JoinColumn(name = "dia_id")
    private DiasDisponiveis dia;

    @Override
    public String toString() {
        return "Consulta{" +
                "profissional= " + profissional +
                ", cliente= " + cliente +
                ", horario= " + getHorario().getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                ", Dia= " + dia.getData().format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")) +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public DiasDisponiveis getDia() {
        return dia;
    }

    public void setDia(DiasDisponiveis dia) {
        this.dia = dia;
    }

    public HorasDisponiveis getHorario() {
        return horario;
    }

    public void setHorario(HorasDisponiveis horario) {
        this.horario = horario;
    }
}
