DROP DATABASE company1;
CREATE DATABASE company1;

DROP DATABASE company2;
CREATE DATABASE company2;


USE company1;
USE company2;

DROP DATABASE company1;
CREATE DATABASE company1;
DROP
CREATE TABLE employees (id BIGINT PRIMARY KEY IDENTITY NOT NULL, first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, email_address VARCHAR(255) NOT NULL);
CREATE TABLE cities (id BIGINT PRIMARY KEY IDENTITY NOT NULL, name VARCHAR(255) NOT NULL, state VARCHAR(20) NOT NULL);

SET IDENTITY_INSERT dbo.employees OFF;

docker exec -it dab9824613d8 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'yourStrong(!)Password'

INSERT INTO cities (name, state) values ('Campinas', 'SP');
INSERT INTO cities (name, state) values ('São Paulo', 'SP');
INSERT INTO cities (name, state) values ('Sorocaba', 'SP');