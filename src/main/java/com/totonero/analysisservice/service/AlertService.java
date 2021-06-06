package com.totonero.analysisservice.service;

import com.totonero.analysisservice.enumerator.BetType;
import com.totonero.analysisservice.enumerator.Rules;
import com.totonero.analysisservice.integration.service.NotificationClientService;
import com.totonero.analysisservice.repository.AlertRepository;
import com.totonero.analysisservice.repository.entity.Alert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repository;
    private final RuleService ruleService;
    private final NotificationClientService notificationClientService;

    public void save(final Rules ruleName, final Long fixtureId, final BetType betType) {
        repository.save(Alert.builder()
                .fixtureId(fixtureId)
                .rule(ruleService.findByNameAndBetType(ruleName, betType))
                .build());

        if(verifyAlertReachedScore(fixtureId, betType)) {
            if(verifyHasRulesFixedTests()) {

            }
            notificationClientService.sendMessage("Jogo: " + fixtureId + "\n" +
                    "Aposta: " + betType + "\n" +
                    "Mensagem: Fui campeao da libertadores jogando no maracana");
        }

    }

    private boolean verifyHasRulesFixedTests() {
        return true;
    }

    private boolean verifyAlertReachedScore(final Long fixtureId, final BetType betType) {
        final int scoreMinimum = ruleService.getMinimumScoreByBetType(betType);
        final int fixtureScore = ruleService.getScoreByFixtureIdAndBetType(fixtureId, betType);
        return fixtureScore >= scoreMinimum;
    }
}
