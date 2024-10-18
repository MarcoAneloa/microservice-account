create database if not exists microservice;
use microservice;

drop table if  exists account;
drop table if  exists account;

-- Table client
create table account (
    id int not null auto_increment,
    name varchar(150) not null,
    address varchar(50) not null,
    phone varchar(50) not null,
    password varchar(50) not null,
    state char(1) not null,
    primary key (id)
);

insert into account (name,address,phone,password,state) values('Jose Lema','Otavalo sn y principal','098254785','1234',1);
insert into account (name,address,phone,password,state) values('Marianela Montalvo','Amazonas y NNUU','097548965','5678',1);
insert into account (name,address,phone,password,state) values('Juan Osorio ','13 junio y Equinoccial','098874587','1245',1);
-- select * from account

-- Table account
create table account (
    id int not null auto_increment,
    number varchar(150) not null,
    type varchar(50) not null,
    balance double not null,
    state char(1) not null,
    customerId int not null,
    primary key (id),
    FOREIGN KEY (customerId) REFERENCES account(id)
);

insert into account (number,type,balance,state,customerId) values('478758','Ahorro',2000,1,1);
insert into account (number,type,balance,state,customerId) values('225487','Corriente',100,1,2);
insert into account (number,type,balance,state,customerId) values('495878','Ahorro',0,1,3);
insert into account (number,type,balance,state,customerId) values('496825','Ahorro',540,1,2);
-- select * from account