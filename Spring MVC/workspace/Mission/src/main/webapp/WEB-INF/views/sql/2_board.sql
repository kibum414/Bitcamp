insert into BOARD values(BOARD_SEQ.nextval, '김하나', 'kim@hanmail.net','제목1', '내용1', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이둘', 'lee@hanmail.net','제목2', '내용2', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '한셋', 'han@hanmail.net','제목3', '내용3', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '오넷', 'oh@hanmail.net','제목4', '내용4', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '최다섯', 'chm@hanmail.net','제목5', '내용5', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김여섯', 'kim@hanmail.net','제목6', '내용6', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이일곱', 'lee@hanmail.net','제목7', '내용7', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '한여덟', 'han@hanmail.net','제목8', '내용8', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '오아홉', 'oh@hanmail.net','제목9', '내용9', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '최열', 'chm@hanmail.net','제목10', '내용10', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '김열한', 'kim@hanmail.net','제목11', '내용11', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이열둘', 'lee@hanmail.net','제목12', '내용12', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '한열셋', 'han@hanmail.net','제목13', '내용13', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '오열넷', 'oh@hanmail.net','제목14', '내용14', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '최열닷', 'chm@hanmail.net','제목15', '내용15', SYSDATE);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;


select * from tab;

desc BOARD