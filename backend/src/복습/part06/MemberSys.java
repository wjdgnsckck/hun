package 복습.part06;

import java.util.Scanner;

public class MemberSys {
	 static Member [] memberlist = new Member[100];
	 static  Scanner sc=  new Scanner(System.in);
	 static int logic = -1;
	 static String password="";
	static	String findid="";
	public static void main(String[] args) {
	  
	 
	   while(true) {
		   System.out.println("-----------회원시스템-----------");
		   System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 선택>");int ch=sc.nextInt();
		   if(ch==1) {회원가입();System.out.println();}
		   else if(ch==2){로그인();}
		   else if(ch==3){아이디찾기();}
		   else if(ch==4){비밀번호찾기();}
		   
	   }
	}
	//실행목적
	static void 회원가입() {
		System.out.println("---------회원가입-------");
		System.out.println("아이디 : "); String inputId=sc.next();
		System.out.println("비밀번호 : "); String inputPw=sc.next();
		System.out.println("이름 : "); String inputName=sc.next();
		System.out.println("전화번호 : "); String inputPhone=sc.next();
		System.out.println("나이 : ");  int age=sc.nextInt();
		Member member =new Member(inputId, inputPw, inputName, inputPhone, age);
		for(int i = 0 ; i<memberlist.length;i++) {
			if(memberlist[i]==null) {System.out.println("안내) 회원가입 성공"); memberlist[i]=member;break;}
			
		}
		
	}
	static void 로그인() {
		System.out.println("-------로그인-------");
		System.out.println("아이디:"); String id = sc.next();
		System.out.println("비밀번호:"); String pw= sc.next();
		for(int i = 0 ; i<memberlist.length ; i++) {
			if(memberlist[i]!=null&&memberlist[i].id.equals(id)&&
					memberlist[i].pw.equals(pw)) {
				logic=i; break;
			}
		}//for end
		if(logic>=0) {System.out.println("안내) 로그인 성공");}
		else {System.out.println("안내)로그인 실패");}
	}
	static void 아이디찾기() {
		System.out.println("----------아이디 찾기----------");
		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("전화번호 : "); String phone = sc.next();
	
		for(int i = 0 ; i<memberlist.length ; i++) {
			if(memberlist[i]!=null&&memberlist[i].id.equals(id)
					&&memberlist[i].phone.equals(phone)) {
				findid=memberlist[i].id; logic=i;
			}
			
		}
		if(logic>=0) {System.out.println("등록된 아이디:"+findid) ;}
		else {System.out.println("등록된아이디가없습니다."); }
		}
	static void 비밀번호찾기() {
		System.out.println("------------비밀번호 찾기----------");
		System.out.println("아이디 : "); String id=sc.next();
		System.out.println("전화번호 : "); String phone = sc.next();
		for(int i = 0 ; i<memberlist.length ; i++) {
			if(memberlist[i]!=null&&memberlist[i].id.equals(id)
					&&memberlist[i].phone.equals(phone)) {
				password=memberlist[i].pw; logic=i;
			}
			
		}//for end
		if(logic>=0) {System.out.println("안내) 회원님의 비밀번호:"+password);}
		else {System.out.println("안내) 등록된 비밀번호가 없습니다.") ;}
		
	}
	
}
