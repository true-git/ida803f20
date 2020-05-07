CREATE USER IF NOT EXISTS 'kitchengardener'@'localhost' IDENTIFIED BY 'greenfingers';
GRANT ALL PRIVILEGES ON *.* TO 'kitchengardener'@'localhost';

CREATE DATABASE IF NOT EXISTS kitchengarden;
USE kitchengarden;

DROP TABLE if EXISTS registred_plants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS plantlibrary;

CREATE TABLE users (
  user_id int(11) AUTO_INCREMENT not null, 
  firstname varchar(64) DEFAULT NULL,
  lastname varchar(64) DEFAULT NULL,
  email varchar(64) DEFAULT NULL,
  pass varchar (64) DEFAULT NULL,
  city varchar(64) DEFAULT NULL, 
  gender ENUM ('male', 'female', 'other') NOT NULL,
  datofbirth DATE NOT NULL, 
  isLoggedIn BOOLEAN NOT NULL,
  PRIMARY KEY (user_id)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO users VALUES 
(1, 'Test', 'Jensen', 'testperson@plantlet.dk', 'salt', 'Testkøbing', 'other', '1985-10-12', false),
(2, 'Test2', 'Hansen', 'test2@email.com', 'peber', 'Nykøbing', 'male', '2000-01-01', false);
 
 
CREATE TABLE plantlibrary (
  plant_id int auto_increment not null,
  latin_name varchar(64) NOT NULL,
  common_name varchar(64) DEFAULT NULL,
  
  climate_zone int DEFAULT NULL,
  PRIMARY KEY (plant_id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO plantlibrary VALUES
(1, 'dandelion', 'dandelionius', 5),
(2, 'sweet potato', 'sweetus potatous', 4);


CREATE TABLE registred_plants (

	user_id int(11) not null,
    plant_id int,
    state ENUM ('frø', 'spirer'),
    dateof DATE NOT NULL,
    foreign key (user_id) references users (user_id),
    foreign key (plant_id) references plantlibrary (plant_id)
);



