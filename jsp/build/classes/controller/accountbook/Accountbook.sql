use JSPWEB;
drop table if exists accountbook;
create table accountbook(
 ano int auto_increment,
 acontent text not null,
 aprice int not null,
 adate datetime default now(),
 primary key(ano)
);
select * from accountbook order by adate desc;
insert into accountbook(acontent,aprice,adate)values(?,?,?);
update accountbook set acontent =? , aprice = ?, adate =?  where ano=?;
delete from accountbook where ano=?;