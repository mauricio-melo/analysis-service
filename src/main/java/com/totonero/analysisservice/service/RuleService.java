package com.totonero.analysisservice.service;

import com.totonero.analysisservice.enumerator.BetType;
import com.totonero.analysisservice.enumerator.Rules;
import com.totonero.analysisservice.repository.RuleRepository;
import com.totonero.analysisservice.repository.entity.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleService {

    private final RuleRepository repository;

    public Rule findByNameAndBetType(final Rules name, final BetType betType) {
        return repository.findByNameAndParentName(name.toString(), betType.toString());
    }

    public int getScoreByFixtureIdAndBetType(final Long fixtureId, final BetType betType) {
        return repository.getScoreByFixtureId(fixtureId, betType.toString());
    }

    public int getMinimumScoreByBetType(final BetType betType) {
        return repository.getMinimumScoreByBetType(betType.toString());
    }

}
