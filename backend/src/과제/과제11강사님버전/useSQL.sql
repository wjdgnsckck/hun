use sqldb4web; 									-- 사용중인 데이터베이스 위치
drop table if exists board;						-- 게시판 table
create table board(
 bno int auto_increment ,  primary key(bno),
 btitle varchar(50) not null,
 bcontent longtext,
 bdate datetime default now(),
 bview int default 0,
 mno int,
	foreign key(mno)references member1(mno) on delete cascade		#회원탈퇴[pk레코드삭제] 되면 FK의 레코드가 같이 삭제
	 -- foreign key(mno)references member1(mno) on delete restrict,     #(생략기본값)회원탈퇴[PK레코드삭제] 할때 FK의 레코드가 존재하면 탈퇴불가
 	 -- foreign key(mno)references member1(mno)on delete set null,		#회원탈퇴[pk레코드삭제] 되면 FK의 값을 NULL수정
  	 -- foreign key(mno)references member1(mno) on delete no action 	#아무런 변화가 없는상태.
);

drop table  if exists  member1;				-- 회원정보 table
create table member1(
	mno int  not null unique auto_increment , primary key(mno),
    mid varchar(20) not null unique,  #unique 로 중복값 제거 입력시 유효성 검사해줌
    mpw varchar(20)not null ,
    mname varchar(20) not null  , 
    mphone varchar(13)not null unique  #unique 로 중복값 제거 입력시 유효성 검사해줌
);
select * from member1;