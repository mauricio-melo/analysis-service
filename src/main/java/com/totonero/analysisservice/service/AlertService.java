package com.totonero.analysisservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.integration.service.NotificationClientService;
import com.totonero.analysisservice.processor.TypeAnalysis;
import com.totonero.analysisservice.processor.factory.FactoryProcessor;
import com.totonero.analysisservice.repository.AlertRepository;
import com.totonero.analysisservice.repository.entity.Alert;
import com.totonero.analysisservice.repository.entity.Bet;
import com.totonero.analysisservice.repository.entity.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repository;
    private final RuleService ruleService;
    private final BetService betService;
    private final NotificationClientService notificationClientService;
    private final FactoryProcessor factoryProcessor;
    private final EntryService entryService;

    public void analysing(final Rules rule, final Long fixtureId, final BetType betType, final Period period) {
        save(rule, fixtureId, betType, period);
        saveAnalyzableRules(fixtureId, betType, period);
        verifyScore(fixtureId, betType, period);
    }

    public void save(final Rules rule, final Long fixtureId, final BetType betType, final Period period) {
        final Alert alert = Alert.builder()
                .fixtureId(fixtureId)
                .rule(ruleService.findByNameAndBetTypeAndPeriod(rule, betType, period))
                .build();

        findByFixtureIdAndRuleNameAndBetAndPeriod(rule, fixtureId, betType, period)
                .ifPresent(exists -> alert.setId(exists.getId()));

        repository.save(alert);
    }

    private void saveAnalyzableRules(final Long fixtureId, final BetType betType, final Period period) {
        ruleService.findAnalysableRulesByBetAndPeriod(betType, period)
                .forEach(rule -> {
                    final TypeAnalysis typeAnalysis = factoryProcessor.analyseRule(Rules.valueOf(rule.getRuleName()));
                    typeAnalysis.analysing(fixtureId, betType, period);
                });
    }

    private void verifyScore(final Long fixtureId, final BetType betType, final Period period) {
        final int minimumScore = betService.findScoreByName(betType, period);
        final int fixtureScore = ruleService.getScoreByFixtureIdAndBetType(fixtureId, betType, period);
        if (fixtureScore >= minimumScore) {
            final Bet bet = betService.findByActualScoreAndPeriodAndBetType(fixtureScore, period, betType);
            final Long teamId = 100L;
            final Long leagueId = 78L;
            final boolean isCup = true;

            entryService.save(Entry.builder()
                    .bet(bet)
                    .fixtureId(fixtureId)
                    .teamId(teamId)
                    .leagueId(leagueId)
                    .isCup(isCup)
                    .score(fixtureScore)
                    .green(false)
                    .build());

            notify(fixtureId, BetType.valueOf(bet.getName()), fixtureScore, period);
        }
    }

    public Optional<Alert> findByFixtureIdAndRuleNameAndBetAndPeriod(final Rules rule, final Long fixtureId,
                                                                     final BetType betType, final Period period) {
        return repository.findByFixtureIdAndRuleNameAndBetAndPeriod(fixtureId, rule.name(), betType.name(), period);
    }

    private void notify(final Long fixtureId, final BetType betType, int fixtureScore, final Period period) {
        final String home = "Flamengo";
        final String away = "Vasco";
        final String leagueName = "Libertadores";
        final String goalsHome = "0";
        final String goalsAway = "3";
        final String country = "AMERICA";

        notificationClientService.sendMessage("*Jogo:* " + fixtureId + "\n" +
                "*Partida:* " + home + " " + goalsHome + " x " + goalsAway + " " + away + "\n" +
                "*Liga:* " + leagueName + "\n" +
                "*Pais:* " + country + "\n" +
                "*Tempo de jogo:* " + period.name() + "\n\n" +
                "*Aposta:* " + betType + "\n" +
                "*Score:* " + fixtureScore);
    }
}
