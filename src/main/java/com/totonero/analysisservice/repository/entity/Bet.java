package com.totonero.analysisservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
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

    @Column(name = "period")
    @Enumerated(EnumType.STRING)
    private Period period;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private BetType name;

    @Column(name = "score")
    private int score;

    @OneToMany(mappedBy = "bet")
    private List<Rule> rules;
}
