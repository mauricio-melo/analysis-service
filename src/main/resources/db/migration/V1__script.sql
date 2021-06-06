CREATE TABLE bet (
  idt_bet           BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  period            VARCHAR(255) NOT NULL,
  name              VARCHAR(255) NOT NULL,
  score             BIGINT NOT NULL
);

CREATE TABLE rule (
  idt_rule          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_bet           BIGINT NOT NULL,
  rule_type         VARCHAR(255) NOT NULL,
  rule_name         VARCHAR(255) NOT NULL,
  score             BIGINT NOT NULL,
  FOREIGN KEY (idt_bet) REFERENCES bet (idt_bet)
);

CREATE TABLE alert (
  idt_alert         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_rule          BIGINT NOT NULL,
  idt_fixture       BIGINT NOT NULL,
  FOREIGN KEY (idt_rule) REFERENCES rule (idt_rule)
);

CREATE TABLE entry (
  idt_entry         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idt_bet           BIGINT NOT NULL,
  idt_fixture       BIGINT NOT NULL,
  idt_team	        BIGINT NOT NULL,
  idt_league        BIGINT NOT NULL,
  is_cup            TINYINT(1) NOT NULL,
  score             BIGINT NOT NULL,
  green             TINYINT(1) NOT NULL,
  FOREIGN KEY (idt_bet) REFERENCES bet (idt_bet)
);
