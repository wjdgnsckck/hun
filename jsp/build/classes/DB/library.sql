use jspweb;
create table library(
lno int auto_increment , 
lname varchar(10) ,
lphonenumber varchar(20) unique,
primary key(lno)
);
drop table library;
insert into library(lno)value(1) ;
insert into library(lno)value(2) ;
insert into library(lno)value(3) ;
insert into library(lno)value(4) ;
insert into library(lno)value(5) ;
insert into library(lno)value(6) ;
insert into library(lno)value(7) ;
insert into library(lno)value(8) ;


select * from library;
update library set lname=?,lphonenumber=?  where lname is null and lno=?  ;