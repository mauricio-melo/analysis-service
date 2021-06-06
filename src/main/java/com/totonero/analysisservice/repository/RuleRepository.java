package com.totonero.analysisservice.repository;

import com.totonero.analysisservice.repository.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuleRepository extends JpaRepository<Rule, Long> {

    @Query(value = "SELECT r FROM Rule r " +
            "WHERE ruleType = 'FIXED' AND ruleName = ?1 " +
            "AND ruleParentId = (SELECT rp.id FROM Rule rp WHERE rp.ruleName = ?2)")
    Rule findByNameAndParentName(final String ruleName, final String betType);

    @Query(value = "SELECT SUM(r.score) FROM Rule r " +
            "JOIN r.alerts a " +
            "WHERE a.fixtureId = ?1 " +
            "AND r.ruleParentId = (SELECT rp.id FROM Rule rp WHERE rp.ruleName = ?2)")
    int getScoreByFixtureId(final Long fixtureId, final String betType);

    @Query(value = "SELECT r.score FROM Rule r " +
            "WHERE r.ruleName = ?1 " +
            "AND r.ruleType = 'BASE'")
    int getMinimumScoreByBetType(final String betTYpe);

    @Query(value = "SELECT SUM(r.score) FROM Rule r " +
            "JOIN r.alerts a " +
            "WHERE a.fixtureId = ?1 " +
            "AND r.ruleParentId = (SELECT rp.id FROM Rule rp WHERE rp.ruleName = ?2)")
    int verifyHasRulesFixedTests(final Long fixtureId, final String betType);
}
