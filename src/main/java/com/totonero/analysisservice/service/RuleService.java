package com.totonero.analysisservice.service;

import java.util.List;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.repository.RuleRepository;
import com.totonero.analysisservice.repository.entity.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleService {

    private final RuleRepository repository;

    public Rule findByNameAndBetTypeAndPeriod(final Rules name, final BetType betType, final Period period) {
        return repository.findByNameAndBetAndPeriod(name.name(), betType.name(), period);
    }

    public int getScoreByFixtureIdAndBetType(final Long fixtureId, final BetType betType, final Period period) {
        return repository.getScoreByFixtureIdAndParentName(fixtureId, betType.name(), period);
    }

    public List<Rule> findAnalysableRulesByBetAndPeriod(final BetType betType, final Period period) {
        return repository.findAnalysableRulesByBetAndPeriod(betType.name(), period);
    }
}
