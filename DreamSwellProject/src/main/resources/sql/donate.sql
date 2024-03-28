CREATE TABLE dreamswelldonate (
    idx int PRIMARY KEY AUTO_INCREMENT,
    userRef int not null,
    boardRef int not null,
    donate int not null,
    content varchar(1000) null,
    regDate timestamp default current_timestamp,
    CONSTRAINT fk_donate_userRef FOREIGN KEY (userRef) REFERENCES dreamUser(idx) on delete cascade,
    CONSTRAINT fk_donate_boardRef FOREIGN KEY (boardRef) REFERENCES dreamswellBoard(idx)
);
select * from dreamswelldonate;
