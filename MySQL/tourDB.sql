drop database if exists tourDB;
create database tourDB;

use tourDB;

create table Customer(
cid int unsigned primary key auto_increment,
firstName varchar (45) not null,
lastName varchar (45) not null,
credits int unsigned not null default 0
);

create table certificate(
cert_id int unsigned primary key auto_increment,
title varchar (45) not null
);

create table guide(
gid int unsigned primary key auto_increment,
firstName varchar (45) not null,
lastName varchar (45) not null,
profits int unsigned not null default 0,
subject varchar (45),
cert_id int unsigned,
foreign key (cert_id) references certificate(cert_id)
);


create table tour(
tid int unsigned primary key auto_increment,
location varchar (45) not null,
cost int unsigned not null default 0,
tdate date not null,
gid int unsigned,
foreign key (gid) references guide(gid) 
);

create table booking(
bid int unsigned primary key auto_increment,
cid int unsigned,
tid int unsigned,
foreign key (cid) references customer(cid) ,
foreign key (tid) references tour(tid) 
);


insert into certificate (title) values('Egypt'),
('Minoan'),
('Myc');
select * from certificate;
select * from guide;
insert into guide (firstName,lastName,subject,cert_id)
values('Nikos','Sampanis','Otieinai',1),
('Chris','Maroulis','OtiNaeinai',2);

insert into tour(location,cost,tdate,gid) values('Athens, Acropolis',300,'2020-01-01',1),
('Cornith, Corn',500,'2020-02-02',2),
('Athens, Monastirakion',100,'2020-01-02',1);
select * from tour;