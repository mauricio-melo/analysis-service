package com.totonero.analysisservice.controller.dto.response;

import java.util.List;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Rules;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResponseDTO {
    private BetType betType;
    private int score;
    private List<RuleDTO> rules;


    @Getter
    @Setter
    @Builder
    public static class RuleDTO {
        private Rules rule;
        private int score;
    }
}
