drop table ADDRESS_FILE;
drop sequence ADDRESS_FILE_SEQ; 
drop table ADDRESS;
drop sequence ADDRESS_SEQ;

create table ADDRESS(
   SEQ number constraint ADDRESS_PK primary key, 
   NAME varchar2(50), 
   ADDR varchar2(50), 
   RDATE date
); 
create sequence ADDRESS_SEQ increment by 1 start with 1 nocache;

insert into ADDRESS values(ADDRESS_SEQ.nextval, '홍길동', '서울시', SYSDATE);
insert into ADDRESS values(ADDRESS_SEQ.nextval, '이순신', '부산시', SYSDATE);
insert into ADDRESS values(ADDRESS_SEQ.nextval, '강감찬', '인천시', SYSDATE);


create sequence ADDRESS_FILE_SEQ increment by 1 start with 1 nocache;
create table ADDRESS_FILE(
   SEQF number constraint ADDRESS_FILE_PK primary key, 
   OFNAME varchar2(50),
   SFNAME varchar2(50), 
   FSIZE number,
   SEQ number constraint ADDRESS_FK references ADDRESS(SEQ) on delete cascade 
); 

insert into ADDRESS_FILE values(ADDRESS_FILE_SEQ.nextval, 'a.png', 'a_123456.png', 1000, 2);
insert into ADDRESS_FILE values(ADDRESS_FILE_SEQ.nextval, 'b.png', 'b_123456.png', 2000, 2);
insert into ADDRESS_FILE values(ADDRESS_FILE_SEQ.nextval, 'c.png', 'c_123456.png', 3000, 2);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='ADDRESS' or TABLE_NAME='ADDRESS_FILE';

select * from ADDRESS_FILE;