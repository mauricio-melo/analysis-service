package com.totonero.analysisservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.totonero.analysisservice.enumerator.BetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "bet")
public class Bet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_bet")
    private Long id;

    @Column(name = "idt_fixture")
    private Long fixtureId;

    @Column(name = "idt_team")
    private Long teamId;

    @Column(name = "idt_league")
    private Long leagueId;

    @Column(name = "is_cup")
    private boolean isCup;

    @Column(name = "bet_type")
    @Enumerated(EnumType.STRING)
    private BetType betType;

    @Column(name = "score")
    private int score;

    @Column(name = "green")
    private boolean green;
}
