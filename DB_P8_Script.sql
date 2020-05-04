CREATE USER IF NOT EXISTS 'kitchengardener'@'localhost' IDENTIFIED BY 'greenfingers';
GRANT ALL PRIVILEGES ON *.* TO 'kitchengardener'@'localhost';

CREATE DATABASE IF NOT EXISTS kitchengarden;
USE kitchengarden;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS plants;

CREATE TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(64) DEFAULT NULL,
  email varchar(64) DEFAULT NULL,
  pass varchar (64) DEFAULT NULL,
  city varchar(64) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO users (username, email, pass, city) VALUES
('Testperson', 'testperson@plantlet.dk', 'test', 'Testkøbing');

CREATE TABLE plants (
  latin_name varchar(64) NOT NULL,
  common_name varchar(64) DEFAULT NULL,
  presentation blob DEFAULT NULL,
  climate_zone int DEFAULT NULL,
  PRIMARY KEY (latin_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO plants VALUES
('dandelionius', 'dandelion', 'præsentation', 5),
('sweetus potatous', 'sweet potato', 'præsentation', 4);

