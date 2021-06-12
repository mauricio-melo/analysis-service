package com.totonero.analysisservice.repository;

import java.util.List;
import java.util.Optional;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.repository.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    @Query(value = "SELECT a FROM Alert a " +
            "JOIN a.rule r " +
            "JOIN r.bet b " +
            "WHERE a.fixtureId = ?1 " +
            "AND r.ruleName = ?2 " +
            "AND b.name = ?3 " +
            "AND b.period = ?4")
    Optional<Alert> findByFixtureIdAndRuleNameAndBetAndPeriod(final Long fixtureId, final Rules ruleName,
                                                              final BetType bet, final Period period);

    @Query(value = "SELECT SUM(r.score) FROM Alert a " +
            "JOIN a.rule r " +
            "JOIN r.bet b " +
            "WHERE a.fixtureId = ?1 " +
            "AND b.name = ?2 " +
            "AND b.period = ?3")
    int getScoreByFixtureIdAndBetTypeAndPeriod(final Long fixtureId, final BetType bet, final Period period);

    @Query(value = "SELECT a FROM Alert a " +
            "JOIN a.rule r " +
            "JOIN r.bet b " +
            "WHERE a.fixtureId = ?1 " +
            "AND b.name = ?2 " +
            "AND b.period = ?3")
    List<Alert> getAllAlertsByFixtureIdAndBetTypeAndPeriod(final Long fixtureId, final BetType bet, final Period period);
}
