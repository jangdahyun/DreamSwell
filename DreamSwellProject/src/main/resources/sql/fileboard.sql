CREATE TABLE dreamswellfileboard (
   idx INT AUTO_INCREMENT PRIMARY KEY,
   REF INT NOT NULL,
   filepath VARCHAR(200) NOT NULL,
   url VARCHAR(200) NOT NULL,
   FOREIGN KEY (REF) REFERENCES dreamswellBoard(idx) ON DELETE CASCADE
);
select *from dreamswellfileboard jfb ;
drop table dreamswellfileboard ;