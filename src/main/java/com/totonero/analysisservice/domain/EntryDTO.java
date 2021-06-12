package com.totonero.analysisservice.domain;

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
public class EntryDTO {
    private Long id;
    private BetDTO bet;
    private Long fixtureId;
    private Long teamId;
    private Long leagueId;
    private boolean isCup;
    private int score;
    private boolean green;
}
