package com.totonero.analysisservice.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.analysisservice.controller.dto.response.ScoreResponseDTO;
import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.enums.BetType;

public class AlertMapper {

    public static ScoreResponseDTO createScoreResponseDTO(final List<AlertDTO> alertDTOS, final int score, final BetType betType) {
        return ScoreResponseDTO.builder()
                .score(score)
                .betType(betType)
                .rules(alertDTOS.stream()
                        .map(alertDTO -> ScoreResponseDTO.RuleDTO.builder()
                                .rule(alertDTO.getRule().getRuleName())
                                .score(alertDTO.getRule().getScore())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
