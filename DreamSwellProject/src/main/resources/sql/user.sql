create table dreamUser(
	idx int primary key auto_increment,
	username varchar(100) not null,
	password varchar(100) not null,
	email1 varchar(100) not null,
	email2 varchar(100) not null,
	profile varchar(2000) null
);

select * from dreamuser;
	