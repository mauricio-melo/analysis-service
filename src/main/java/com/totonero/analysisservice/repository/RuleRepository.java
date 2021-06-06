package com.totonero.analysisservice.repository;

import java.util.List;

import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuleRepository extends JpaRepository<Rule, Long> {

    @Query(value = "SELECT r FROM Rule r " +
            "JOIN r.bet b " +
            "WHERE r.ruleName = ?1 " +
            "AND b.name = ?2 " +
            "AND b.period = ?3")
    Rule findByNameAndBetAndPeriod(final String name, final String bet, final Period period);

    @Query(value = "SELECT SUM(r.score) FROM Rule r " +
            "JOIN r.alerts a " +
            "JOIN r.bet b " +
            "WHERE a.fixtureId = ?1 " +
            "AND b.name = ?2 " +
            "AND b.period = ?3")
    int getScoreByFixtureIdAndParentName(final Long fixtureId, final String bet, final Period period);

    @Query(value = "SELECT r FROM Rule r " +
            "JOIN r.bet b " +
            "WHERE r.ruleType = 'ANALYZABLE' " +
            "AND b.name = ?1 " +
            "AND b.period = ?2")
    List<Rule> findAnalysableRulesByBetAndPeriod(final String bet, final Period period);
}
