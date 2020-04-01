CREATE USER IF NOT EXISTS 'kitchengardener'@'localhost' IDENTIFIED BY 'greenfingers';
GRANT ALL PRIVILEGES ON *.* TO 'kitchengardener'@'localhost';

CREATE DATABASE IF NOT EXISTS kitchengarden;
USE kitchengarden;

DROP TABLE IF EXISTS plants;

CREATE TABLE plants (
  id int(11) NOT NULL AUTO_INCREMENT,
  common_name varchar(64) DEFAULT NULL,
  latin_name varchar(64) DEFAULT NULL,
  climate_zone int DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO plants VALUES
(1, 'dandelion', 'dandelionius', 5),
(2, 'sweet potato', 'sweetus potatous', 4);