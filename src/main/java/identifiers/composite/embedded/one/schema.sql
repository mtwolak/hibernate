DROP DATABASE IF EXISTS HibernateExample;

CREATE DATABASE HibernateExample;

USE HibernateExample;

CREATE TABLE COURSE_ANNOTATION (
  tutor varchar(10) NOT NULL,
  title varchar(10) NOT NULL,
  totalStudents int,
  PRIMARY KEY (tutor, title)
);