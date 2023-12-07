package br.edu.infnet.model.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DiasDisponiveis {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
