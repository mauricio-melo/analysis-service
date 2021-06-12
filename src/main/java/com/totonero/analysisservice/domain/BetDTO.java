package com.totonero.analysisservice.domain;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
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
public class BetDTO {
    private Long id;
    private Period period;
    private BetType name;
    private int score;
}
