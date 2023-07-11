DROP TABLE IF EXISTS giftCertificate;

CREATE TABLE giftCertificate (
id              BIGINT NOT NULL AUTO_INCREMENT,
name            VARCHAR(50) NOT NULL,
description     VARCHAR(500) NOT NULL,
price           DOUBLE(40,2) NOT NULL,
duration        INT NOT NULL,
createDate      DATE NOT NULL,
lastUpdateDate  DATE NOT NULL,

PRIMARY KEY(id)
);

INSERT INTO giftCertificate(name, description, price, duration, createDate, lastUpdateDate) values
("name01", "description01", 01.01, 1, DATE('2001-01-01'), DATE('2001-01-01'));
INSERT INTO giftCertificate(name, description, price, duration, createDate, lastUpdateDate) values
("name02", "description02", 01.02, 2, DATE('2001-01-02'), DATE('2001-01-02'));
INSERT INTO giftCertificate(name, description, price, duration, createDate, lastUpdateDate) values
("name03", "description03", 01.03, 3, DATE('2001-01-03'), DATE('2001-01-03'));