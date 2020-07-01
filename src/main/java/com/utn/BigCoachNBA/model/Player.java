package com.utn.BigCoachNBA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Integer idPlayer;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_surname")
    private String lastName;

    @Column(name = "position")
    private String position;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_team")
    @JsonBackReference
    private Team team;
}
