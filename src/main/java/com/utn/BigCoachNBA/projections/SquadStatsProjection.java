package com.utn.BigCoachNBA.projections;

public interface SquadStatsProjection {
    String getPlayer_name();
    String getPlayer_surname();
    String getPosition();
    Integer getPoints();
    Integer getBounces();
    Integer getAssists();
    Integer getMinutes();
    Integer getFouls();
}
