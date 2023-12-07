package br.edu.infnet.model.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class HorasDisponiveis {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    private LocalTime hora;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
