package com.utn.BigCouchNBA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Jugadores")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Integer idPlayer;

    @Column(name = "nombre_jugador")
    private String name;

    @Column(name = "apellido_jugador")
    private String lastName;

    @Column(name = "posicion")
    private String position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Team team;
}
