package com.utn.BigCoachNBA.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private Integer idEquipo;

    @Column(name = "team_name")
    private String name;

    @OneToMany(mappedBy = "team")
    List<Player> players = new ArrayList<Player>();
}
