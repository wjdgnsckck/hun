use jspweb;
drop table if exists pcategory;
create table pcategory(
	pcno int auto_increment ,
    pcname varchar(100) not null,
    primary key(pcno)
);
insert pcategory(pcname)values('노트북');
insert pcategory(pcname)values('테블릿');
insert pcategory(pcname)values('냉장고');
drop table if exists product;
create table product(
	pno int auto_increment,
    pname varchar(100) not null,
    pcontent longtext ,
    pprice int  unsigned,			-- signed(기본값:음수사용 +-21억)/ unsigned (음수사용 x 양수전용이므로 40억)	
    pstate tinyint ,                
    pdate datetime default now(),
    plat varchar(30),
    plng varchar(30),
    pcno int ,
    mno int, 
	primary key(pno),
    foreign key (pcno) references pcategory(pcno) on delete set null on update cascade,
    foreign key(mno) references member(mno) on delete set null on update cascade
);
drop table if exists productimg;
create table productimg(
	pimgno int auto_increment ,
    pimg longtext,
    pno int,
    primary key(pimgno),
    foreign key(pno) references product (pno) on delete cascade on update cascade
)