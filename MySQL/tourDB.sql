drop database if exists tourDB;
create database tourDB;

SET FOREIGN_KEY_CHECKS=1;

use tourDB;

drop table if exists user;
create table user(
id int unsigned primary key not null auto_increment,
username varchar(20) not null,
password varchar(100) not null
);

drop table if exists customer;
create table customer(
id int unsigned primary key auto_increment,
firstName varchar (45) not null,
lastName varchar (45) not null,
credits int unsigned  default 0
);

drop table if exists certificate;
create table certificate(
cert_id int unsigned primary key auto_increment,
title varchar (45) not null
);

drop table if exists guide;
create table guide(
id int unsigned primary key auto_increment,
firstName varchar (45) not null,
lastName varchar (45) not null,
profits int unsigned  default 0,
subject varchar (45),
cert_id int unsigned,
foreign key (cert_id) references certificate(cert_id)
);

drop table if exists role;
create table role(
rid int unsigned primary key not null auto_increment,
rname varchar(30),
unique (rname)
);

drop table if exists user_role;
create table user_role(
id int unsigned,
rid int unsigned,
primary key(id,rid),
constraint userrole_fk1 foreign key (id) references user(id),
constraint userrole_fk2 foreign key (rid) references role(rid)
);


drop table if exists tour;
create table tour(
tid int unsigned primary key auto_increment,
location varchar (45) not null,
cost int unsigned not null default 0,
tdate date not null,
gid int unsigned,
foreign key (gid) references guide(id) on delete cascade 
);

create table booking(
bid int unsigned primary key auto_increment,
cid int unsigned,
tid int unsigned,
foreign key (cid) references customer(id) ,
foreign key (tid) references tour(tid) on delete cascade
);


insert into role(rname) values('ROLE_ADMIN');
insert into role(rname) values ('ROLE_GUIDE');
insert into role(rname) values ('ROLE_CUSTOMER');
																			-- pass is 1234
insert into user (username, password) values ('admin', '$2a$10$D59ZadCxXwvWRi39ASUFweNxuzCvldwJNAu6fYH2Fcr9YKeAAcKee');

-- insert into user (username, password) values ('customer', '$2a$10$K5pZsA5s0ibOaU6q.Ba5XeE4vnT0yiWeCSbRr9rY6Wrp1M.DOf1bS');

insert into user_role (id,rid) values(1,1);
-- insert into user_role (id,rid) values(2,3);


select * from user;
select * from customer;
select * from role;
select * from user_role;
select * from tour;
select * from guide;
select * from certificate;

insert into guide values(1,"Chris","Mark",500,"AAA",1);
insert into tour values(1,"Kriti",600,"1999-09-09",1);
delete from guide where id=1;
insert into  certificate values(1,"Pasparation");