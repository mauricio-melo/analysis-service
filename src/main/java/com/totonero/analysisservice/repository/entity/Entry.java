package com.totonero.analysisservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_entry")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_bet")
    private Bet bet;

    @Column(name = "idt_fixture")
    private Long fixtureId;

    @Column(name = "idt_team")
    private Long teamId;

    @Column(name = "idt_league")
    private Long leagueId;

    @Column(name = "is_cup")
    private boolean isCup;

    @Column(name = "score")
    private int score;

    @Column(name = "green")
    private boolean green;
}
