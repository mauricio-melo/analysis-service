package com.totonero.analysisservice.repository;

import java.util.Optional;

import com.totonero.analysisservice.enums.Period;
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
    Optional<Alert> findByFixtureIdAndRuleNameAndBetAndPeriod(final Long fixtureId, final String ruleName,
                                                              final String bet, final Period period);
}
