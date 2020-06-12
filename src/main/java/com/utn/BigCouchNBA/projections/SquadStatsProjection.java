package com.utn.BigCouchNBA.projections;

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
