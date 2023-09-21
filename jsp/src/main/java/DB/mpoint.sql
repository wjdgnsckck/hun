drop table if exists mpoint;
create table mpoint(
	mpno varchar(40),
	mno int,
    mpamount int unsigned default 0, 			-- 44억
    mpcomment varchar(100) ,        				-- 지급내역
    mpdate datetime default now() ,
    primary key(mpno),
    foreign key (mno) references member(mno) on delete set null on update cascade
);
insert into mpoint( mpno, mno , mpamount,mpcomment)values('asd',1,5000,'내역');
insert into mpoint( mpno, mno , mpamount,mpcomment)values('asdf',1,5000,'내역');
insert into mpoint( mpno, mno , mpamount,mpcomment)values('asdd',1,5000,'내역');
insert into mpoint( mpno, mno , mpamount,mpcomment)values('asdg',1,5000,'내역');