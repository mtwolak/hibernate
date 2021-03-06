DROP DATABASE IF EXISTS HibernateExample;

CREATE DATABASE HibernateExample;

USE HibernateExample;

CREATE TABLE SHOWROOM_LIST (
SHOWROOM_ID int(10) NOT NULL AUTO_INCREMENT,
manager varchar(255) DEFAULT NULL,
PRIMARY KEY (SHOWROOM_ID)
);


CREATE TABLE CAR_LIST (
CAR_ID int(11) NOT NULL AUTO_INCREMENT,
color varchar(255) DEFAULT NULL,
name varchar(255) DEFAULT NULL,
SHOWROOM_ID int(11) DEFAULT NULL,
PRIMARY KEY (CAR_ID),
FOREIGN KEY (SHOWROOM_ID) REFERENCES SHOWROOM_LIST (SHOWROOM_ID)
);