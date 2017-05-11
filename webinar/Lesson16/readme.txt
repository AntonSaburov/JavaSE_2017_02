Базы данных

Эдгар Кодд - IBM
Реляционные базы данных - RDBMS
1. Унифицированное общение и представление данных
2. Реляционность

- Структура
- API для модификации и чтения

Oracle
DB2

PostgreSQL
MySQL
MS SQL Server
Sybase Server

SQL - Structure Query Langauge


NoSQL - Not only SQL
- Document
- Key-Value - Map<Key, Value>
- Graph

- Hadoop - MapReduce








1. List, Array - NameList
- Element 1
- Element 2
…..
- Element N

Attributes - Name, Type

Contact
- email
- givenName
- surName
- phone

StudentOrder
- StudentOrderID
- DateIssue
- Reference PersonAdult - husband
- Reference PersonAdult - wife
- References PersonChild - children

Person
- surname
- givenName
- reference adult
- reference child

PersonAdult
… serial
- number

PersonChild
- ….


Structured Query Language
- Data Definition Language - DDL
- Data Manipulation Language - DML


one-to-one
one-to-many
many-to-many


GroupID 1

Student 1 GroudID 1
Student 2 GroudID 1
Student 3 GroudID 1
Student 4 GroudID 1




CRUD - Create, Read, Delete, Update



INSERT INTO <table> () VALUES ()

DELETE FROM <table> WHERE ..

UPDATE <table> SET field1=value, field2=value WHERE ..

SELECT * FROM <table>




ORM - Object Relation Mapping - Hibernate, JPA










CREATE TABLE sp_student_order
(
   student_order_id SERIAL,
   student_order_date date,
   h_surName varchar(50) not null,
   h_givenName varchar(50) not null,
   h_patronymic varchar(50) not null,
   h_date_of_birth date not null,
   h_passport_seria varchar(10) not null,
   h_passport_number varchar(10) not null,
   h_date_issue date not null,
   h_date_expire date,
   w_surName varchar(50) not null,
   w_givenName varchar(50) not null,
   w_patronymic varchar(50) not null,
   w_date_of_birth date not null,
   w_passport_seria varchar(10) not null,
   w_passport_number varchar(10) not null,
   w_date_issue date not null,
   w_date_expire date,
   primary key (student_order_id)
);


CREATE TABLE sp_student_order_child
(
   student_child_id SERIAL,
   student_order_id int not null,
   c_surName varchar(50) not null,
   c_givenName varchar(50) not null,
   c_patronymic varchar(50) not null,
   c_date_of_birth date not null,
   c_birth_document varcnar(50),
   primary key (student_child_id) 
);


alter table sp_student_order_child add constraint sp_refChild
    foreign key (student_order_id)
    references sp_student_order(student_order_id);













