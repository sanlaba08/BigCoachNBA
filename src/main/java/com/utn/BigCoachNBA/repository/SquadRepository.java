package com.utn.BigCoachNBA.repository;

import com.utn.BigCoachNBA.model.Squad;
import com.utn.BigCoachNBA.projections.SquadPlayerProjection;
import com.utn.BigCoachNBA.projections.SquadStatsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Integer> {
    @Query(value = "select *" + " from v_player_per_squad where dni = ?", nativeQuery = true)
    List<SquadStatsProjection> getPlayersStatsSquads(String dni);

    @Query(value = "select *" + " from v_only_player_per_squad where dni = ?", nativeQuery = true)
    List<SquadPlayerProjection> getPlayersSquads(String dni);

    @Procedure(procedureName = "sp_insert_player_per_squad")
    void addPlayerById(@Param("pId_player") Integer idPlayer, @Param("pDni") String dni);

    @Procedure(procedureName = "sp_update_player_per_squad")
    void updatePlayerById(@Param("pIdPlayerOld") Integer idPlayerOld, @Param("pIdPlayerNew") Integer idPlayerNew, @Param("pDni") String dni);

//    @Query(value = "select s.* from squads where s.id_squad = :id")
//    Squad getById(@Param("id") Integer id);

}
