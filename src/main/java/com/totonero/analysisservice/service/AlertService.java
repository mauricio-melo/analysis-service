package com.totonero.analysisservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.domain.BetDTO;
import com.totonero.analysisservice.domain.EntryDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.integration.notification.service.NotificationClientService;
import com.totonero.analysisservice.repository.AlertRepository;
import com.totonero.analysisservice.repository.entity.Alert;
import com.totonero.analysisservice.service.analysing.processor.TypeAnalysis;
import com.totonero.analysisservice.service.analysing.factory.FactoryProcessor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public void analysing(final AlertDTO alertDTO, final Rules rule, final BetType betType, final Period period) {
        final Long fixtureId = alertDTO.getFixtureId();
        save(rule, fixtureId, betType, period);
        saveAnalyzableRules(betType, period, alertDTO);
        verifyScore(alertDTO, betType, period);
    }

    public void save(final Rules rule, final Long fixtureId, final BetType betType, final Period period) {
        if (findByFixtureIdAndRuleNameAndBetAndPeriod(fixtureId, rule, betType, period).isPresent()) {
            return;
        }
        final AlertDTO alertDTO = AlertDTO.builder()
                .fixtureId(fixtureId)
                .rule(ruleService.findByNameAndBetTypeAndPeriod(rule, betType, period))
                .build();

        repository.save(modelMapper.map(alertDTO, Alert.class));
    }

    private void saveAnalyzableRules(final BetType betType, final Period period, final AlertDTO alertDTO) {
        ruleService.findAnalysableRulesByBetAndPeriod(betType, period)
                .forEach(rule -> {
                    final TypeAnalysis typeAnalysis = factoryProcessor.analyseRule(rule.getRuleName());
                    typeAnalysis.analysing(alertDTO, betType, period);
                });
    }

    private void verifyScore(final AlertDTO alertDTO, final BetType betType, final Period period) {
        final int minimumScore = betService.findScoreByName(betType, period);
        final int fixtureScore = getScoreByFixtureIdAndBetTypeAndPeriod(alertDTO.getFixtureId(), betType, period);
        if (fixtureScore >= minimumScore) {
            final BetDTO bet = betService.findByActualScoreAndPeriodAndBetType(fixtureScore, period, betType);
            final Long teamId = 100L;
            final Long leagueId = 78L;
            final boolean isCup = true;

            entryService.save(EntryDTO.builder()
                    .bet(bet)
                    .fixtureId(alertDTO.getFixtureId())
                    .teamId(teamId)
                    .leagueId(leagueId)
                    .isCup(isCup)
                    .score(fixtureScore)
                    .green(false)
                    .build());

            notify(alertDTO.getFixtureId(), bet.getName(), fixtureScore, period);
        }
    }

    public int getScoreByFixtureIdAndBetTypeAndPeriod(final Long fixtureId, final BetType betType, final Period period) {
        return repository.getScoreByFixtureIdAndBetTypeAndPeriod(fixtureId, betType, period);
    }

    public List<AlertDTO> getAllAlertsByFixtureIdAndBetTypeAndPeriod(final Long fixtureId, final BetType betType, final Period period) {
        return repository.getAllAlertsByFixtureIdAndBetTypeAndPeriod(fixtureId, betType, period).stream()
                .map(alert -> modelMapper.map(alert, AlertDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<AlertDTO> findByFixtureIdAndRuleNameAndBetAndPeriod(final Long fixtureId, final Rules rule,
                                                                        final BetType betType, final Period period) {
        return repository.findByFixtureIdAndRuleNameAndBetAndPeriod(fixtureId, rule, betType, period)
                .map(alert -> modelMapper.map(alert, AlertDTO.class));
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

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
