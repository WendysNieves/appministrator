CREATE DATABASE IF NOT EXISTS appministrator;
USE appministrator;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  identification varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  cellphone varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

GRANT ALL PRIVILEGES ON appministrator.* To 'user'@'localhost' IDENTIFIED BY 'password';