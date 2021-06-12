package com.totonero.analysisservice.service;

import static com.totonero.analysisservice.enums.BetType.LIMITE;
import static com.totonero.analysisservice.enums.BetType.RACE;
import static com.totonero.analysisservice.enums.BetType.ZOIAO;

import com.totonero.analysisservice.domain.BetDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.exceptions.ResourceNotFoundException;
import com.totonero.analysisservice.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetService {

    private final BetRepository repository;
    private final ModelMapper modelMapper;

    public int findScoreByName(final BetType betType, final Period period) {
        return repository.findScoreByNameAndPeriod(betType, period);
    }

    public BetDTO findByNameAndPeriod(final BetType betType, final Period period) {
        return repository.findByNameAndPeriod(betType, period)
                .map(bet -> modelMapper.map(bet, BetDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public BetDTO findByActualScoreAndPeriodAndBetType(final int fixtureScore, final Period period, final BetType betType) {
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
