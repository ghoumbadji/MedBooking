-- Creates and populates client table
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `email_address` VARCHAR(80) NOT NULL,
  `password` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `client` (`client_id`, `first_name`, `last_name`, `date_of_birth`, `email_address`, `password`) VALUES
(1, 'Yann', 'LECUN', '1960-07-08', 'yannlecun@meta.com', '#godfather#turing#cnn'),
(2, 'Stéphanie', 'DELESTRE', '1969-12-30', 'stephaniedelestre@qapa.com', 'true_entrepreneur^456'),
(3, 'Peter', 'THIEL', '1967-10-11', 'peterthiel@palantir.com', '100%contrarian'),
(4, 'Larry', 'FINK', '1952-11-02', 'larryfink@blackrock.com', 'larrytheboss'),
(5, 'Andy', 'ALLO', '1989-01-13', 'andyallo@prime.us', '#uploadactor'),
(6, 'Flora', 'COQUEREL', '1994-04-14', 'floracoquerel@missfrance.com', '%theprettiestone%'),
(7, 'Lionel', 'MESSI', '1987-06-24', 'lionelmessi@fifa.com', 'thegoat8'),
(8, 'Issa Lorenzo', 'DIAKHATÉ', '1992-06-06', 'issadiakhate@lmf.com', '#ldo#nrm#667'),
(9, 'Djimon', 'HOUNSOU', '1964-04-24', 'djimonhounsou@hollywood.com', '#neverbackdown'),
(10, 'Guido', 'VAN ROSSUM', '1956-01-31', 'guidovanrossum@python.com', '@thetruehero');


-- Creates and populates doctor table
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email_address` VARCHAR(80) NOT NULL,
  `specialities` VARCHAR(150) NOT NULL,
  `average_rating` FLOAT DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `doctor` (`doctor_id`, `first_name`, `last_name`, `email_address`, `specialities`) VALUES
(1, 'Gregory', 'HOUSE', 'gregoryhouse@drhouse.com',  'médecine diagnostique'),
(2, 'Meredith', 'GREY', 'meredithgrey@greysanatomy.com', 'chirurgie cardiothoracique'),
(3, 'Miranda', 'BAILEY', 'mirandabailey@greysanatomy.com', 'médecine interne'),
(4, 'Alex', 'KAREV', 'alexkarev@greysanatomy.com', 'pédiatrie'),
(5, 'Owen', 'HUNT', 'owenhunt@greysanatomy.com', 'traumatologie'),
(6, 'Arizona', 'ROBBINS', 'arizonarobbins@greysanatomy.com', 'pédiatrie'),
(7, 'Connor', 'RHODES', 'connorrhodes@chicagomed.com', 'traumatologie - chirurgie cardiothoracique'),
(8, 'Ava', 'BEKKER', 'avabekker@chicagomed.com', 'chirurgie cardiothoracique'),
(9, 'Robin', 'CHARLES', 'robincharles@chicagomed.com', 'épidemiologie'),
(10, 'Iggy', 'FROME', 'iggyfrome@newamsterdam.com', 'psychiatrie');


-- Creates and populates employee table
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email_address` VARCHAR(80) NOT NULL,
  `password` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `employee` (`emp_id`, `first_name`, `last_name`, `email_address`, `password`)
VALUES
(1, 'Ilian Siham', 'ALI BOTO', 'ilianaliboto@medbooking.com', 'password1'),
(2, 'Valérie Line Romualda', 'BIVIGOU', 'valeriebivigou@medbooking.com', 'password2'),
(3, 'Margot', 'DRUILHE', 'margotdruilhe@medbooking.com', 'password3'),
(4, 'Georges', 'HOUMBADJI', 'georgeshoumbadji@medbooking.com', 'password4'),
(5, 'James', 'GOSLING', 'jamesgosling@java.com', '#javacreator'),
(6, 'Edgar', 'CODD', 'edgarcodd@relationalmodel.com', '#sqlonmyway'),
(7, 'James', 'GOSLING', 'jamesgosling@java.com', '#javacreator'),
(8, 'Admin', 'admin', 'admin@test.com', 'password'),
(9, 'Auto', 'AUTO', 'auto@auto.com', '1234'),
(10, 'Test', 'TEST', 'test@test.com', '00000');

-- Creates and populates appointment table
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
    `appointment_id` INT NOT NULL AUTO_INCREMENT,
    `address` VARCHAR(100) NOT NULL,
    `date` DATE NOT NULL,
    `hour` TIME NOT NULL,
    `rating` INT DEFAULT NULL,
    `doctor_id` INT NOT NULL,
    `client_id` INT DEFAULT NULL,
    PRIMARY KEY (`appointment_id`),
    KEY `doctor_id` (`doctor_id`),
    KEY `client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE SET NULL ON UPDATE CASCADE;

INSERT INTO `appointment` (`appointment_id`, `address`, `date`, `hour`, `rating`, `doctor_id`, `client_id`)
VALUES
(1, 'Gaffney Chicago Medical, Chicago', '2024-04-15', '15:30', NULL, 7, NULL),
(2, 'Gaffney Chicago Medical, Chicago', '2024-05-10', '10:00', NULL, 7, NULL),
(3, 'Seattle Grace, Seattle', '2024-06-01', '09:30', 5, 2, 1),
(4, 'Gaffney Chicago Medical, Chicago', '2024-06-25', '08:00', 3, 7, 4),
(5, 'Princeton-Plainsboro, New Jersey', '2024-04-03', '08:00', NULL, 1, 2),
(6, 'Seattle Grace, Seattle', '2024-04-15', '14:00', NULL, 2, NULL),
(7, 'Seattle Grace, Seattle', '2024-06-11', '10:00', NULL, 3, NULL),
(8, 'Gaffney Chicago Medical, Chicago', '2024-07-18', '14:00', NULL, 8, NULL),
(9, 'Princeton-Plainsboro, New Jersey', '2024-04-19', '14:00', NULL, 1, NULL),
(10, 'Princeton-Plainsboro, New Jersey', '2024-04-25', '14:00', NULL, 1, NULL);

COMMIT;
