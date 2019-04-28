create database bancojava;
use bancojava;
create table Aluno (
ID int PRIMARY KEY AUTO_INCREMENT, 
Nome VARCHAR(50)
);

/*---------------------------*/
create table Professor (
ID int PRIMARY KEY AUTO_INCREMENT, 
Nome VARCHAR(50)
);

/*---------------------------*/
create table Usuario (
ID int PRIMARY KEY AUTO_INCREMENT, 
Nome VARCHAR(50),
Senha VARCHAR(20)
);