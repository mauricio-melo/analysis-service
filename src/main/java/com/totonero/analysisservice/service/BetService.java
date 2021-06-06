package com.totonero.analysisservice.service;

import static com.totonero.analysisservice.enums.BetType.LIMITE;
import static com.totonero.analysisservice.enums.BetType.RACE;
import static com.totonero.analysisservice.enums.BetType.ZOIAO;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.BetRepository;
import com.totonero.analysisservice.repository.entity.Bet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetService {

    private final BetRepository repository;

    public int findScoreByName(final BetType betType, final Period period) {
        return repository.findScoreByNameAndPeriod(betType.name(), period);
    }

    public Bet findByNameAndPeriod(final BetType betType, final Period period) {
        return repository.findByNameAndPeriod(betType.name(), period);
    }

    public Bet findByActualScoreAndPeriodAndBetType(final int fixtureScore, final Period period, final BetType betType) {
        if (betType.equals(RACE)) {
            return findByNameAndPeriod(RACE, period);
        }
        final int minimumScoreZoiao = findScoreByName(ZOIAO, period);
        if (fixtureScore > minimumScoreZoiao) {
            throw new RuntimeException();
        } else if (minimumScoreZoiao == fixtureScore) {
            return findByNameAndPeriod(ZOIAO, period);
        }
        return findByNameAndPeriod(LIMITE, period);
    }
}
