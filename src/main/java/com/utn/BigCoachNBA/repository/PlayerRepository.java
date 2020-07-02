package com.utn.BigCoachNBA.repository;

import com.utn.BigCoachNBA.model.Player;
import com.utn.BigCoachNBA.projections.PlayerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select *" + " from v_team_info where Team = ?", nativeQuery = true)
    List<PlayerProjection> getPlayersByTeam(String team);

    @Query(value = "select * from v_team_info where Position = ?", nativeQuery = true)
    List<PlayerProjection> getPlayersByPosition(String position);

    @Query(value = "select * from v_team_info where Age = ?", nativeQuery = true)
    List<PlayerProjection> getPlayersByAge(Integer age);

    @Query(value = "select * from v_team_info where PlayerName = ?", nativeQuery = true)
    List<PlayerProjection> getPlayersByFirstName(String name);

    @Query(value = "select * from v_team_info where PlayerLastName = ?", nativeQuery = true)
    List<PlayerProjection> getPlayersByLastName(String lastname);
}
