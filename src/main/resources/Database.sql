create database if not exists microservice;
use microservice;

drop table if  exists customer;
drop table if  exists account;

-- Table client
create table customer (
    id int not null auto_increment,
    name varchar(150) not null,
    address varchar(50) not null,
    phone varchar(50) not null,
    password varchar(50) not null,
    state char(1) not null,
    primary key (id)
);

insert into customer (name,address,phone,password,state) values('Jose Lema','Otavalo sn y principal','098254785','1234',1);
insert into customer (name,address,phone,password,state) values('Marianela Montalvo','Amazonas y NNUU','097548965','5678',1);
insert into customer (name,address,phone,password,state) values('Juan Osorio ','13 junio y Equinoccial','098874587','1245',1);
-- select * from customer

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

create table transaction (
    id int not null auto_increment,
    date varchar(15) not null,
    type varchar(50) not null,
    value double not null,
    initial_balance double not null,
    final_balance double not null,
    customerId int not null,
    accountId int not null,
    primary key (id),
    FOREIGN KEY (customerId) REFERENCES customer(id),
    FOREIGN KEY (accountId) REFERENCES account(id)
);

select t.id, t.date, c.name, a.number, a.type, t.initial_balance, a.state, t.value, t.final_balance from transaction t join customer c on t.customerId=c.id join account a on t.accountId=a.id;

insert into transaction (date,type,value,initial_balance,final_balance,customerId,accountId) values('10/02/2022','Deposito ',100,100,200,2,2);