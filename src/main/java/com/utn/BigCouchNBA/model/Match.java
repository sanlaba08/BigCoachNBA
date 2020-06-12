package com.utn.BigCouchNBA.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private Integer idMatch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_local_team")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Team localTeam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_visitor_team")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Team visitorTeam;

    @Column(name = "match_date")
    private Date matchDate;
}
