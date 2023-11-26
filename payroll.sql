
create database  payroll;
use payroll;
create table login (username varchar(16),password varchar(16));
insert into login values ('admin','admin');
create table new_employee(Eid int primary key,name varchar(25),gender varchar(6),address varchar(40),state varchar(30),city varchar(30),email varchar(50),phone int8);

create table salary(Eid int not null unique,hra float8,da float8,mid float8,pf float8,basis float8 );

create table attendance(Eid int ,first_half varchar(7),date varchar(40),sal varchar(30));

