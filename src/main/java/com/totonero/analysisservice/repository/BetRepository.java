package com.totonero.analysisservice.repository;

import com.totonero.analysisservice.repository.entity.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
