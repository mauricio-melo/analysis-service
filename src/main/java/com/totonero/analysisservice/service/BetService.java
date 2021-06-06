package com.totonero.analysisservice.service;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetService {

    private final BetRepository repository;

    public int findScoreByName(final BetType betType, final Period period) {
        return repository.findScoreByNameAndPeriod(betType.name(), period);
    }
}
