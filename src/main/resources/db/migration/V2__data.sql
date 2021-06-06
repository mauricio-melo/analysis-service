INSERT INTO bet(period, name, score)
VALUES ('FIRST_HALF', 'LIMITE', 75);

INSERT INTO bet(period, name, score)
VALUES ('FIRST_HALF', 'ZOIAO', 95);

INSERT INTO bet(period, name, score)
VALUES ('SECOND_HALF', 'RACE', 70);

INSERT INTO bet(period, name, score)
VALUES ('SECOND_HALF', 'LIMITE', 75);

INSERT INTO bet(period, name, score)
VALUES ('SECOND_HALF', 'ZOIAO', 95);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'FIXED', 'BALL_POSSESSION_GREATER_THAN_65', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'FIXED', 'CORNER_GREATER_THAN_2', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'FIXED', 'KICKS_GREATER_THAN_4', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'FIXED', 'RED_CARD', 10);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'FIXED', 'VAR', 5);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'ANALYZABLE', 'FAVORITE_TEAM_TYING', 10);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'ANALYZABLE', 'FAVORITE_TEAM_LOSING', 15);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'LIMITE' AND b.period = 'FIRST_HALF'),
'ANALYZABLE', 'CUP', 5);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'BALL_POSSESSION_GREATER_THAN_65', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'CORNER_EQUAL_5', 15);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'CORNER_EQUAL_7', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'KICKS_GREATER_THAN_7', 15);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'RED_CARD', 10);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'FIXED', 'VAR', 5);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'ANALYZABLE', 'FAVORITE_TEAM_LOSING', 20);

INSERT INTO rule(idt_bet, rule_type, rule_name, score)
VALUES ((SELECT b.idt_bet FROM bet b WHERE b.name = 'RACE' AND b.period = 'SECOND_HALF'),
'ANALYZABLE', 'CUP', 5);