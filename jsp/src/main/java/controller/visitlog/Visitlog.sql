drop database if exists JSPWEB;
create database JSPWEB;
use JSPWEB;
drop table if exists visitlog;
create table visitlog(
vno int auto_increment ,	-- 식별번호 ( 방문록번호 ) , 자동번호 부여
vwriter varchar(30) not null,		-- (방문록작성자명) , 공백불가능
vpwd varchar(10) not null,			-- (방문록비밀번호) , 공백불가능
vcontent text not null,				-- (방문록 내용)
vdate datetime default now(),		-- ( 방문록 작성일 / 사긴 ) 생략시 자동 현재 날짜 삽입
primary key(vno)
);
insert into visitlog(vwriter,vpwd,vcontent) values("차차","차차차","차차차차");
select * from visitlog order by vdate desc;
#3. 수정
update visitlog set vcontent='수정방문록' where vno=3; /* vno 3 이면 vcontent의 값을 수정*/
update visitlog set vcontent=? where vno=? and vpwd = ?;

#3. 삭제
delete from visitlog where vno=3; /* vno 3인 레코드 삭제*/
delete from visitlog where vno = 17 and vpwd = 'asd' ; /*vno 3 이면서 vpwd 1234 이면 레코드 삭제*/