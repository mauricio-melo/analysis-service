package com.totonero.analysisservice.domain;

import com.totonero.analysisservice.enums.RuleType;
import com.totonero.analysisservice.enums.Rules;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleDTO {
    private Long id;
    private BetDTO bet;
    private RuleType ruleType;
    private Rules ruleName;
    private int score;
}
