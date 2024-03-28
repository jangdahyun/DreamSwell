CREATE TABLE dreamswellBoard (
    idx int PRIMARY KEY AUTO_INCREMENT,
    thumbnail varchar(2000) NOT NULL,
    title varchar(500) NOT NULL,
    content varchar(4000) NOT NULL,
    regDate timestamp DEFAULT CURRENT_TIMESTAMP,
    stDate timestamp NOT NULL,
    endDate timestamp NOT NULL,
    targetAmount int NOT NULL,
    currentAmount int DEFAULT 0,
    love int DEFAULT 0,
    userRef int NOT NULL,
    category1 int NOT NULL,
    category2 int null,
    category3 int null,
    CONSTRAINT fk_userRef FOREIGN KEY (userRef) REFERENCES dreamUser(idx) on delete cascade,
    CONSTRAINT fk_category1 FOREIGN KEY (category1) REFERENCES dreamcategory(idx),
    CONSTRAINT fk_category2 FOREIGN KEY (category2) REFERENCES dreamcategory(idx),
    CONSTRAINT fk_category3 FOREIGN KEY (category3) REFERENCES dreamcategory(idx)
);
select *from dreamswellboard;

drop table dreamswellboard;
