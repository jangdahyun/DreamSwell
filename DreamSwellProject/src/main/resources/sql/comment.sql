
create table dreamSwellComment(
	idx int primary key auto_increment,
	userRef int not null,
	boardRef int not null,
	regDate timestamp default current_timestamp,
	content varchar(500) not null,
	CONSTRAINT fk_comment_userRef FOREIGN KEY (userRef) REFERENCES dreamUser(idx) on delete cascade,
    CONSTRAINT fk_comment_boardRef FOREIGN KEY (boardRef) REFERENCES dreamswellBoard(idx) on delete cascade
);

select * from dreamSwellComment ;
drop table dreamSwellComment;

