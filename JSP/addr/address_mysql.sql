#> mysql -u boot -p

use boot_schema

drop table ADDRESS;

create table ADDRESS(
   SEQ int AUTO_INCREMENT PRIMARY KEY, 
   NAME varchar(10), 
   ADDR varchar(20), 
   RDATE datetime
); 

insert into ADDRESS(NAME, ADDR, RDATE) values('한동균', '서울시', now());
insert into ADDRESS(NAME, ADDR, RDATE) values('임성지', '부산시', now());
insert into ADDRESS(NAME, ADDR, RDATE) values('안정은', '인천시', now());

commit;

