CREATE TABLE rule (
  idt_rule          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_rule_parent   BIGINT NULL,
  rule_type         VARCHAR(255) NOT NULL,
  rule_name         VARCHAR(255) NOT NULL,
  score             BIGINT NOT NULL
);

CREATE TABLE alert (
  idt_alert         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_rule          BIGINT NOT NULL,
  idt_fixture       BIGINT NOT NULL,
  FOREIGN KEY (idt_rule) REFERENCES rule (idt_rule)
);

CREATE TABLE bet (
  idt_bet           BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_fixture       BIGINT NOT NULL,
  idt_team	        BIGINT NOT NULL,
  idt_league        BIGINT NOT NULL,
  is_cup            TINYINT(1) NOT NULL,
  bet_type          VARCHAR(255) NOT NULL,
  score             BIGINT NOT NULL,
  green             TINYINT(1) NOT NULL
);
