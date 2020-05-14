CREATE USER IF NOT EXISTS 'kitchengardener'@'localhost' IDENTIFIED BY 'greenfingers';
GRANT ALL PRIVILEGES ON *.* TO 'kitchengardener'@'localhost';

CREATE DATABASE IF NOT EXISTS kitchengarden;
USE kitchengarden;

DROP TABLE if EXISTS registered_plants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS plants;

CREATE TABLE users (
  user_id int(11) NOT NULL auto_increment,
  firstname varchar(64) NOT NULL,
  lastname varchar(64) NOT NULL,
  email varchar(64) NOT NULL,
  pass varchar (64) NOT NULL,
  city varchar(64) NOT NULL,
  PRIMARY KEY (user_id)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO users (firstname, lastname, email, pass, city) VALUES 
('Test', 'Jensen', 'testperson@plantlet.dk', 'salt', 'Testkøbing'),
('Test2', 'Hansen', 'test2@email.com', 'peber', 'Nykøbing'),
('Donald', 'Trump', 'duck@scor.dk', 'dt', 'dc');
 
CREATE TABLE plants (
  plant_id int NOT NULL auto_increment,
  latin_name varchar(64) NOT NULL,
  common_name varchar(64) NOT NULL,
  presentation varchar(64) NOT NULL,
  cultivation varchar(64) NOT NULL,
  light varchar(64) NOT NULL,
  soil varchar(64) NOT NULL,
  watering varchar(64) NOT NULL,
  temp_moist varchar(64) NOT NULL,
  fertilizer varchar(64) NOT NULL,
  PRIMARY KEY (plant_id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO plants
(latin_name, common_name, presentation, cultivation, light, soil, watering, temp_moist, fertilizer) VALUES
('Dandelionius', 'dandelion', 'presentation', 'cultivation', 'light', 'soil', 'watering', 'temp_moist', 'fertilizer');

CREATE TABLE registered_plants (
user_id int(11) NOT NULL,
plant_id int,
state ENUM ('frø', 'spirer'),
plantedondate DATE NOT NULL,
foreign key (user_id) references users (user_id),
foreign key (plant_id) references plants (plant_id)
);