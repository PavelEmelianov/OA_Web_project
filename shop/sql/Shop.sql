CONNECT 'jdbc:derby://localhost:1527/Zoo_shop;create=true;user=pavel;password=emelianov';

drop table Tools;
drop table Food;
drop table Animals;

create table Animals(

id integer  primary key generated always as identity,
animal_name VARCHAR(20) not null unique,
animal_price integer not null

);

INSERT INTO Animals VALUES (default,'Dog',5);
INSERT INTO Animals VALUES (default,'Cat',10);
INSERT INTO Animals VALUES (default,'Rabbit',20);
INSERT INTO Animals VALUES (default,'Hamster',40);


create table Food (

id integer primary key generated always as identity,
food_name varchar (20) unique,
food_origin varchar (20),
food_price integer not null,
animals_id integer references Animals(id) on delete cascade on update restrict

);

INSERT INTO Food VALUES (DEFAULT,'DogFood1','Poland',100,1);
INSERT INTO Food VALUES (DEFAULT,'DogFood2','Germany',200,1);
INSERT INTO Food VALUES (DEFAULT,'DogFood3','Denmark',300,1);

INSERT INTO Food VALUES (DEFAULT,'CatFood1','Poland',100,2);
INSERT INTO Food VALUES (DEFAULT,'CatFood2','Germany',200,2);
INSERT INTO Food VALUES (DEFAULT,'CatFood3','Denmark',300,2);

INSERT INTO Food VALUES (DEFAULT,'RabbitFood1','Poland',100,3);
INSERT INTO Food VALUES (DEFAULT,'RabbitFood2','Germany',200,3);
INSERT INTO Food VALUES (DEFAULT,'RabbitFood3','Denmark',300,3);

INSERT INTO Food VALUES (DEFAULT,'HamsterFood1','Poland',100,4);
INSERT INTO Food VALUES (DEFAULT,'HamsterFood2','Germany',200,4);
INSERT INTO Food VALUES (DEFAULT,'HamsterFood3','Denmark',300,4);


create table Tools (

id integer primary key generated always as identity,
tool_name varchar(20) unique,
tool_origin varchar (20),
tool_weight integer not null,
tool_price integer not null,
animals_id integer references Animals(id) on delete cascade on update restrict

);

INSERT INTO Tools VALUES (DEFAULT,'DogTools1','Poland',2,100,1);
INSERT INTO Tools VALUES (DEFAULT,'DogTools2','Germany',4,200,1);
INSERT INTO Tools VALUES (DEFAULT,'DogTools3','Denmark',6,300,1);

INSERT INTO Tools VALUES (DEFAULT,'CatTools1','Poland',2,100,2);
INSERT INTO Tools VALUES (DEFAULT,'CatTools2','Germany',4,200,2);
INSERT INTO Tools VALUES (DEFAULT,'CatTools3','Denmark',6,300,2);

INSERT INTO Tools VALUES (DEFAULT,'RabbitTools1','Poland',2,100,3);
INSERT INTO Tools VALUES (DEFAULT,'RabbitTools2','Germany',4,200,3);
INSERT INTO Tools VALUES (DEFAULT,'RabbitTools3','Denmark',6,300,3);

INSERT INTO Tools VALUES (DEFAULT,'HamsterTools1','Poland',2,100,4);
INSERT INTO Tools VALUES (DEFAULT,'HamsterTools2','Germany',4,200,4);
INSERT INTO Tools VALUES (DEFAULT,'HamsterTools3','Denmark',6,300,4);


