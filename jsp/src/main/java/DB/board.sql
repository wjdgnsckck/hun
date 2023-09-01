use jspweb;
#게시판 카테고리
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment,
    bcname varchar(30) not null,
    primary key(bcno)
);
#샘플 [ 공지사항 , 자유게시판 ,노하우]
insert into bcategory value(1,'공지사항');
insert into bcategory value(2,'자유게시판');
insert into bcategory value(3,'노하우');

#게시판
drop table if exists board;
create table board(
	bno		int auto_increment,
    btitle	varchar(30) not null,
    bcontent longtext ,
    bfile	longtext,
    bdate datetime default now(),
    bview  int default 0,
    mno		int,
    bcno	int ,
    primary key (bno),
    foreign key(mno) references member(mno) on delete  cascade, 
    -- 회원탈퇴시 게시물 삭제
    foreign key(bcno) references bcategory(bcno) on delete cascade on update cascade
     -- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시  fk도 같이 변경
    );
    