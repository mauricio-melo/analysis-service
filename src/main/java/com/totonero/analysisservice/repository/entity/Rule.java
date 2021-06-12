package com.totonero.analysisservice.repository.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.totonero.analysisservice.enums.RuleType;
import com.totonero.analysisservice.enums.Rules;
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
@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idt_rule")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_bet")
    private Bet bet;

    @Column(name = "rule_type")
    @Enumerated(EnumType.STRING)
    private RuleType ruleType;

    @Column(name = "rule_name")
    @Enumerated(EnumType.STRING)
    private Rules ruleName;

    @Column(name = "score")
    private int score;

    @OneToMany(mappedBy = "rule")
    private List<Alert> alerts;
}
