--create user spring identified by java;
--grant resource, connect to spring;
--conn spring/java;

drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
   SEQ bigint NULL AUTO_INCREMENT PRIMARY KEY,
   WRITER varchar(15), 
   EMAIL varchar(20),
   SUBJECT varchar(20), 
   CONTENT varchar(20), 
   RDATE date
); 

insert into BOARD(writer, email, subject, content, rdate) values('공병찬', 'kim@hanmail.net','제목1', '내용1', now());
insert into BOARD(writer, email, subject, content, rdate) values('김보라', 'lee@hanmail.net','제목2', '내용2', now());
insert into BOARD(writer, email, subject, content, rdate) values('김성태', 'han@hanmail.net','제목3', '내용3', now());
insert into BOARD(writer, email, subject, content, rdate) values('김세영', 'oh@hanmail.net','제목4', '내용4', now());
insert into BOARD(writer, email, subject, content, rdate) values('김소담', 'chm@hanmail.net','제목5', '내용5', now());
insert into BOARD(writer, email, subject, content, rdate) values('남철호', 'kim@hanmail.net','제목6', '내용6', now());
insert into BOARD(writer, email, subject, content, rdate) values('모건일', 'lee@hanmail.net','제목7', '내용7', now());
insert into BOARD(writer, email, subject, content, rdate) values('손영빈', 'han@hanmail.net','제목8', '내용8', now());
insert into BOARD(writer, email, subject, content, rdate) values('송승훈', 'oh@hanmail.net','제목9', '내용9', now());
insert into BOARD(writer, email, subject, content, rdate) values('안정은', 'chm@hanmail.net','제목10', '내용10', now());
insert into BOARD(writer, email, subject, content, rdate) values('윤별', 'kim@hanmail.net','제목11', '내용11', now());
insert into BOARD(writer, email, subject, content, rdate) values('임성지', 'lee@hanmail.net','제목12', '내용12', now());
insert into BOARD(writer, email, subject, content, rdate) values('장현봉', 'han@hanmail.net','제목13', '내용13', now());
insert into BOARD(writer, email, subject, content, rdate) values('전세환', 'oh@hanmail.net','제목14', '내용14', now());
insert into BOARD(writer, email, subject, content, rdate) values('조예진', 'chm@hanmail.net','제목15', '내용15', now());

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;


select * from tab;

desc BOARD