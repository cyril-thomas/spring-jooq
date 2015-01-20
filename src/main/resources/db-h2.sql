create table author(
    id int PRIMARY KEY,
    first_name varchar(250),
    last_name varchar(250)
);

create table book(
    id int PRIMARY KEY,
    title varchar(250),
    author_id int not null,
    CONSTRAINT author_book FOREIGN KEY (author_id) REFERENCES author(id)
);


insert into author(id,first_name,last_name) values(1,'Cyril','Thomas');
insert into author(id,first_name,last_name) values(2,'Matt','Olsen');
insert into author(id,first_name,last_name) values(3,'James','Reynolds');
insert into author(id,first_name,last_name) values(4,'Steve','Hansen');
insert into author(id,first_name,last_name) values(6,'Babu','Subbramittam');
insert into author(id,first_name,last_name) values(7,'Kurt','Perry');
insert into author(id,first_name,last_name) values(8,'Jed','Allen');


insert into book(id,title,author_id) values(1,'Spring in deep understanding',1);
insert into book(id,title,author_id) values(2,'Jooq in deep understanding',1);
insert into book(id,title,author_id) values(3,'Groovy in deep understanding',1);
insert into book(id,title,author_id) values(4,'AWS in motion',2);
insert into book(id,title,author_id) values(5,'Rails in motion',2);
insert into book(id,title,author_id) values(6,'Salesforce in motion',2);
insert into book(id,title,author_id) values(7,'FIP in action',2);