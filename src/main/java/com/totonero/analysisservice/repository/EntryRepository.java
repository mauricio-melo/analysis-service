package com.totonero.analysisservice.repository;

import java.util.Optional;

import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Query(value = "SELECT e FROM Entry e " +
            "JOIN e.bet b " +
            "JOIN b.rules r " +
            "JOIN r.alerts a " +
            "WHERE a.fixtureId = ?1 " +
            "AND b.name = ?2 " +
            "AND b.period = ?3")
    Optional<Entry> findByFixtureIdAndBetAndPeriod(final Long fixtureId, final String name, final Period period);
}
