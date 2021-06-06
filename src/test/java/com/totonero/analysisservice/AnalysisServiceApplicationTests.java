package com.totonero.analysisservice;

import static com.totonero.analysisservice.enumerator.BetType.LIMITE_FIRST_HALF;
import static com.totonero.analysisservice.enumerator.Rules.BALL_POSSESSION_GREATER_THAN_65;
import static com.totonero.analysisservice.enumerator.Rules.CORNER_GREATER_THAN_2;
import static com.totonero.analysisservice.enumerator.Rules.KICKS_GREATER_THAN_4;
import static com.totonero.analysisservice.enumerator.Rules.RED_CARD;
import static com.totonero.analysisservice.enumerator.Rules.VAR;

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
	void contextLoads() {
		service.save(BALL_POSSESSION_GREATER_THAN_65, 82201872L, LIMITE_FIRST_HALF);
		service.save(CORNER_GREATER_THAN_2, 82201872L, LIMITE_FIRST_HALF);
		service.save(KICKS_GREATER_THAN_4, 82201872L, LIMITE_FIRST_HALF);
		service.save(RED_CARD, 82201872L, LIMITE_FIRST_HALF);
		service.save(VAR, 82201872L, LIMITE_FIRST_HALF);



	}

}
