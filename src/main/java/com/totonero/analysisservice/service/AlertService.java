package com.totonero.analysisservice.service;

import java.util.List;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.integration.service.NotificationClientService;
import com.totonero.analysisservice.repository.AlertRepository;
import com.totonero.analysisservice.repository.entity.Alert;
import com.totonero.analysisservice.repository.entity.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repository;
    private final RuleService ruleService;
    private final BetService betService;
    private final NotificationClientService notificationClientService;

    public Alert save(final Alert alert) {
        return repository.save(alert);
    }

    public void save(final Rules ruleName, final Long fixtureId, final BetType betType, final Period period) {
        final Alert alert = save(Alert.builder()
                .fixtureId(fixtureId)
                .rule(ruleService.findByNameAndBetTypeAndPeriod(ruleName, betType, period))
                .build());

        saveAnalyzableRules(fixtureId, betType, period);

        if(verifyAlertReachedScore(fixtureId, betType, period)) {
            if(verifyHasRulesFixedTests()) {

            }
            notificationClientService.sendMessage("Jogo: " + fixtureId + "\n" +
                    "Aposta: " + betType + "\n" +
                    "Mensagem: Fui campeao da libertadores jogando no maracana");
        }

    }

    private void saveAnalyzableRules(final Long fixtureId, final BetType betType, final Period period) {
        final List<Rule> analysableRules = ruleService.findAnalysableRulesByBetAndPeriod(betType, period);
    }

    private boolean verifyHasRulesFixedTests() {
        return true;
    }

    private boolean verifyAlertReachedScore(final Long fixtureId, final BetType betType, final Period period) {
        final int scoreMinimum = betService.findScoreByName(betType, period);
        final int fixtureScore = ruleService.getScoreByFixtureIdAndBetType(fixtureId, betType, period);
        return fixtureScore >= scoreMinimum;
    }
}
