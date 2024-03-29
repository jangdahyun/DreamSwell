drop table dreamcategory;
create table dreamcategory(
	idx int primary key auto_increment,
	categoryName varchar(100) not null
);

INSERT INTO dreamcategory (categoryName) VALUES ('장애인식개선');
INSERT INTO dreamcategory (categoryName) VALUES ('식사지원');
INSERT INTO dreamcategory (categoryName) VALUES ('어려운이웃');
INSERT INTO dreamcategory (categoryName) VALUES ('장애인');
INSERT INTO dreamcategory (categoryName) VALUES ('우리사회');
INSERT INTO dreamcategory (categoryName) VALUES ('독거노인');
INSERT INTO dreamcategory (categoryName) VALUES ('청년');
INSERT INTO dreamcategory (categoryName) VALUES ('기본생활지원');
INSERT INTO dreamcategory (categoryName) VALUES ('유기동물');
INSERT INTO dreamcategory (categoryName) VALUES ('아동청소년');
INSERT INTO dreamcategory (categoryName) VALUES ('생계지원');
INSERT INTO dreamcategory (categoryName) VALUES ('실버세대');
INSERT INTO dreamcategory (categoryName) VALUES ('장애인가정');
INSERT INTO dreamcategory (categoryName) VALUES ('지구촌');
INSERT INTO dreamcategory (categoryName) VALUES ('교육지원');

select * from dreamcategory ;

