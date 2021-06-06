INSERT INTO rule(rule_type, rule_name, score)
VALUES ("BASE", "LIMITE_FIRST_HALF", 75);

INSERT INTO rule(rule_type, rule_name, score)
VALUES ("BASE", "RACE_SECOND_HALF", 70);

INSERT INTO rule(rule_type, rule_name, score)
VALUES ("BASE", "LIMITE_SECOND_HALF", 75);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "FIXED", 'BALL_POSSESSION_GREATER_THAN_65', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "FIXED", 'CORNER_GREATER_THAN_2', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "FIXED", 'KICKS_GREATER_THAN_4', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "FIXED", 'RED_CARD', 10);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "FIXED", 'VAR', 5);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "ANALYZABLE", 'FAVORITE_TEAM_TYING', 10);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "ANALYZABLE", 'FAVORITE_TEAM_LOSING', 15);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'LIMITE_FIRST_HALF'), "ANALYZABLE", 'CUP', 5);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'BALL_POSSESSION_GREATER_THAN_65', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'CORNER_EQUAL_5', 15);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'CORNER_EQUAL_7', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'KICKS_GREATER_THAN_7', 15);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'RED_CARD', 10);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "FIXED", 'VAR', 5);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "ANALYZABLE", 'FAVORITE_TEAM_LOSING', 20);

INSERT INTO rule(idt_rule_parent, rule_type, rule_name, score)
VALUES ((SELECT r.idt_rule FROM rule r WHERE r.rule_name = 'RACE_SECOND_HALF'), "ANALYZABLE", 'CUP', 5);