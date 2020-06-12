package com.utn.BigCouchNBA.repository;

import com.utn.BigCouchNBA.model.Squad;
import com.utn.BigCouchNBA.projections.PlayerProjection;
import com.utn.BigCouchNBA.projections.SquadStatsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Integer> {
    @Query(value = "select *" + " from v_player_per_squad", nativeQuery = true)
    List<SquadStatsProjection> getPlayersStatsSquads();
}
