DROP DATABASE IF EXISTS HibernateExample;

CREATE DATABASE HibernateExample;

USE HibernateExample;

CREATE TABLE USER_TABLE (
  user_id int(20) NOT NULL,
  user_name varchar(255) NULL,
  PRIMARY KEY (user_id)
);