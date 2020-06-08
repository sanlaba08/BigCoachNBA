package com.utn.BigCouchNBA.repository;

import com.utn.BigCouchNBA.model.Player;
import com.utn.BigCouchNBA.projections.PlayerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select *" + " from v_team_info where Team = ?", nativeQuery = true)
    public List<PlayerProjection> getPlayersByTeam(String team);
}
