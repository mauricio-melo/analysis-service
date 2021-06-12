package com.totonero.analysisservice;

import static com.totonero.analysisservice.enums.BetType.LIMITE;
import static com.totonero.analysisservice.enums.Period.FIRST_HALF;
import static com.totonero.analysisservice.enums.Rules.BALL_POSSESSION_GREATER_THAN_65;
import static com.totonero.analysisservice.enums.Rules.CORNER_GREATER_THAN_2;
import static com.totonero.analysisservice.enums.Rules.RED_CARD;
import static com.totonero.analysisservice.enums.Rules.VAR;

import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.service.AlertService;
import com.totonero.analysisservice.service.RuleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnalysisServiceApplicationTests {

    @Autowired
    private AlertService service;

    @Autowired
    private RuleService ruleService;

    @Test
    void limiteFirstHalf() {

        AlertDTO alertDTO = AlertDTO.builder()
                .fixtureId(657674L)
                .favoriteTeamId(768L)
                .leagueId(4L)
                .build();

        service.analysing(alertDTO, BALL_POSSESSION_GREATER_THAN_65, LIMITE, FIRST_HALF);
        service.analysing(alertDTO, CORNER_GREATER_THAN_2, LIMITE, FIRST_HALF);
        service.analysing(alertDTO, RED_CARD, LIMITE, FIRST_HALF);
        service.analysing(alertDTO, VAR, LIMITE, FIRST_HALF);
        // 75
    }
//
//    @Test
//    void raceSecondHalf() {
//        service.analysing(BALL_POSSESSION_GREATER_THAN_65, 45478L, RACE, SECOND_HALF);
//        service.analysing(CORNER_EQUAL_7, 45478L, RACE, SECOND_HALF);
//        service.analysing(RED_CARD, 45478L, RACE, SECOND_HALF);
//        // 70
//    }
//
//    @Test
//    void limiteSecondHalf() {
//        service.analysing(CORNER_GREATER_THAN_5, 345453L, LIMITE, SECOND_HALF);
//        service.analysing(KICKS_GREATER_THAN_10, 345453L, LIMITE, SECOND_HALF);
//        service.analysing(RED_CARD, 345453L, LIMITE, SECOND_HALF);
//        service.analysing(VAR, 345453L, LIMITE, SECOND_HALF);
//        // 75
//    }
//
//
//    @Test
//    void testAlertDuplicate() {
//        final Long fixtureId = 5578785L;
//        final BetType betType = LIMITE;
//        final Period period = SECOND_HALF;
//        service.analysing(CORNER_GREATER_THAN_5, fixtureId, betType, period);
//        service.analysing(CORNER_GREATER_THAN_5, fixtureId, betType, period);
//        int score = ruleService.getScoreByFixtureIdAndBetType(fixtureId, betType, period);
//        if(score == 40) {
//
//        }
//    }

}
