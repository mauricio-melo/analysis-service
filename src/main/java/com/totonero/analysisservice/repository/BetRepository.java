package com.totonero.analysisservice.repository;

import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BetRepository extends JpaRepository<Bet, Long> {

    @Query(value = "SELECT b.score FROM Bet b " +
            "WHERE b.name = ?1 " +
            "AND b.period = ?2")
    int findScoreByNameAndPeriod(final String name, final Period period);

    Bet findByNameAndPeriod(final String name, final Period period);
}
