CREATE USER IF NOT EXISTS 'kitchengardener'@'localhost' IDENTIFIED BY 'greenfingers';
GRANT ALL PRIVILEGES ON *.* TO 'kitchengardener'@'localhost';

CREATE DATABASE IF NOT EXISTS kitchengarden;
USE kitchengarden;

DROP TABLE if EXISTS registred_plants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS plantlibrary;

CREATE TABLE users (
  user_id int(11) NOT NULL auto_increment,
  firstname varchar(64) NOT NULL,
  lastname varchar(64) NOT NULL,
  email varchar(64) NOT NULL,
  pass varchar (64) NOT NULL,
  city varchar(64) NOT NULL, 
  gender ENUM ('male', 'female', 'other') NOT NULL,
  dateofbirth DATE NOT NULL, 
  isLoggedIn BOOLEAN NOT NULL,
  PRIMARY KEY (user_id)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO users (firstname, lastname, email, pass, city, gender, dateofbirth, isLoggedIn) VALUES 
('Test', 'Jensen', 'testperson@plantlet.dk', 'salt', 'Testkøbing', 'other', '1985-10-12', false),
('Test2', 'Hansen', 'test2@email.com', 'peber', 'Nykøbing', 'male', '2000-01-01', false);
 
 
CREATE TABLE plantlibrary (
  plant_id int NOT NULL auto_increment,
  latin_name varchar(64) NOT NULL,
  common_name varchar(64) DEFAULT NULL,
  climate_zone int DEFAULT NULL,
  presentation blob DEFAULT NULL,
  PRIMARY KEY (plant_id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO plantlibrary (latin_name, common_name, climate_zone) VALUES
('Dandelionius', 'dandelion', 5),
('Sweetos potatos', 'Sweet potatos', 4);


CREATE TABLE registred_plants (

	user_id int(11) not null,
    plant_id int,
    state ENUM ('frø', 'spirer'),
    plantedondate DATE NOT NULL,
    foreign key (user_id) references users (user_id),
    foreign key (plant_id) references plantlibrary (plant_id)
);

