package com.totonero.analysisservice.controller;

import static com.totonero.analysisservice.controller.mapper.AlertMapper.createScoreResponseDTO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.totonero.analysisservice.controller.dto.request.AlertRequestDTO;
import com.totonero.analysisservice.controller.dto.response.ScoreResponseDTO;
import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(AlertController.ALERT_ENDPOINT)
public class AlertController {

    public static final String ALERT_ENDPOINT = "/alert";

    private final AlertService service;

    @PostMapping(path = "/analysis", consumes = APPLICATION_JSON_VALUE)
    public void analysisAlert(@RequestBody final AlertRequestDTO requestDTO) {
        final AlertDTO alertDTO = AlertDTO.builder()
                .fixtureId(requestDTO.getFixtureId())
                .favoriteTeamId(requestDTO.getFavoriteTeamId())
                .leagueId(requestDTO.getLeagueId())
                .build();

        final Rules rule = requestDTO.getRule();
        final BetType betType = requestDTO.getBetType();
        final Period period = requestDTO.getPeriod();

        service.analysing(alertDTO, rule, betType, period);
    }

    @GetMapping(path = "/score", produces = APPLICATION_JSON_VALUE)
    public ScoreResponseDTO getScore(@RequestParam("fixtureId") final Long fixtureId,
                                     @RequestParam("betType") final BetType betType,
                                     @RequestParam("period") final Period period) {
        final List<AlertDTO> alertDTOS = service.getAllAlertsByFixtureIdAndBetTypeAndPeriod(fixtureId, betType, period);
        final int score = service.getScoreByFixtureIdAndBetTypeAndPeriod(fixtureId, betType, period);
        return createScoreResponseDTO(alertDTOS, score, betType);
    }
}
