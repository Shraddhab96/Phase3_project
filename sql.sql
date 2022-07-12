drop database simplilearn;
create database simplilearn;
Use simplilearn;

create table purchase(
id int not null auto_increment,
name_id int,
product_id int,
ts timestamp,
constraint name foreign key (name_id) references user(id),
constraint product foreign key (product_id) references product(id),
primary key(id));

select* from purchase;
drop table purchase;


create table Product(
id int not null auto_increment,
name varchar(100),category varchar(100),
primary key(id));
select* from product;


create table User(
id int not null auto_increment,
name varchar(100),
primary key(id));

INSERT INTO User VALUE  (101,'Yashwant Kanetkar');
INSERT INTO User VALUE  (201,'Ramraov bhut');
INSERT INTO User VALUE  (301,'priya');
INSERT INTO User VALUE  (401,'sanket');
INSERT INTO User VALUE  (501,'Amruth');
select* from User;