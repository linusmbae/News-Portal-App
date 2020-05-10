
CREATE DATABASE news_portal_database;
\c news_portal_database;

CREATE TABLE users (id serial PRIMARY KEY, name VARCHAR, email VARCHAR, phone VARCHAR, idnumber int);

CREATE TABLE news (id serial PRIMARY KEY, content VARCHAR, type VARCHAR);

CREATE TABLE department (id serial PRIMARY KEY, name VARCHAR, floor VARCHAR);

CREATE TABLE department_with_user (id serial PRIMARY KEY, department_id int, user_id int, user_role VARCHAR, user_position VARCHAR);


CREATE DATABASE news_portal_database_test WITH TEMPLATE news_portal_database;