package com.totonero.analysisservice;

import static com.totonero.analysisservice.enums.BetType.LIMITE;
import static com.totonero.analysisservice.enums.BetType.RACE;
import static com.totonero.analysisservice.enums.Period.FIRST_HALF;
import static com.totonero.analysisservice.enums.Period.SECOND_HALF;
import static com.totonero.analysisservice.enums.Rules.BALL_POSSESSION_GREATER_THAN_65;
import static com.totonero.analysisservice.enums.Rules.CORNER_EQUAL_7;
import static com.totonero.analysisservice.enums.Rules.CORNER_GREATER_THAN_2;
import static com.totonero.analysisservice.enums.Rules.CORNER_GREATER_THAN_5;
import static com.totonero.analysisservice.enums.Rules.KICKS_GREATER_THAN_10;
import static com.totonero.analysisservice.enums.Rules.KICKS_GREATER_THAN_4;
import static com.totonero.analysisservice.enums.Rules.KICKS_GREATER_THAN_7;
import static com.totonero.analysisservice.enums.Rules.RED_CARD;
import static com.totonero.analysisservice.enums.Rules.VAR;

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
        service.analysing(BALL_POSSESSION_GREATER_THAN_65, 1111111L, LIMITE, FIRST_HALF);
        service.analysing(CORNER_GREATER_THAN_2, 1111111L, LIMITE, FIRST_HALF);
        service.analysing(RED_CARD, 1111111L, LIMITE, FIRST_HALF);
        service.analysing(VAR, 1111111L, LIMITE, FIRST_HALF);
        // 75
    }

    @Test
    void raceSecondHalf() {
        service.analysing(BALL_POSSESSION_GREATER_THAN_65, 2222L, RACE, SECOND_HALF);
        service.analysing(CORNER_EQUAL_7, 2222L, RACE, SECOND_HALF);
        service.analysing(RED_CARD, 2222L, RACE, SECOND_HALF);
        // 70
    }

    @Test
    void limiteSecondHalf() {
        service.analysing(CORNER_GREATER_THAN_5, 333L, LIMITE, SECOND_HALF);
        service.analysing(KICKS_GREATER_THAN_10, 333L, LIMITE, SECOND_HALF);
        service.analysing(RED_CARD, 333L, LIMITE, SECOND_HALF);
        service.analysing(VAR, 333L, LIMITE, SECOND_HALF);
        // 75
    }

}
