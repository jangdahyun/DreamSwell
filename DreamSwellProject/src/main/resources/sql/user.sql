create table dreamUser(
	idx int primary key auto_increment,
	username varchar(100) not null,
	password varchar(100) not null,
	nickname varchar(100) NOT NULL,
	email1 varchar(100) not null,
	email2 varchar(100) not null,
	profile varchar(2000) NULL,
	role varchar(100) NOT null
);

select * from dreamuser;


insert into dreamUser (username, password, nickName, email1, email2, role)
values ('admin', '123456', 'admin', ' ', ' ', 'ROLE_ADMIN');
insert into dreamUser (username, password, nickName, email1, email2, role)
values ('master', '123456', 'master', ' ', ' ', 'ROLE_ADMIN');
insert into dreamUser (username, password, nickName, email1, email2, role)
values ('webmaster', '123456', 'webmaster', ' ', ' ', 'ROLE_ADMIN');
insert into dreamUser (username, password, nickName, email1, email2, role)
values ('root', '123456', 'root', ' ', ' ', 'ROLE_ADMIN');
insert into dreamUser (username, password, nickName, email1, email2, role)
values ('dba', '123456', 'dba', ' ', ' ', 'ROLE_ADMIN');
	