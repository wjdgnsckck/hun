package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Member {
	Scanner scanner = new Scanner(System.in);
	//필드
	static Member[] memberList = new Member[100];
	String id="";
	String pw="";
	String name="";
	String phone="";
	String age="";
	
	
	public void 회원가입(){
		Member me=new Member();	//내부 객체 생성
		
		System.out.println("아이디:"); 					String id=scanner.next();
		System.out.println("비밀번호:");					String pw=scanner.next();
		System.out.println("이름:");						String name=scanner.next();
		System.out.println("전화번호:");					String phone=scanner.next();
		System.out.println("나이:");						String age=scanner.next();
		//입력시 유효성검사,이름
		 for (Member existingMember : memberList) {
		        if (existingMember != null && existingMember.name.equals(name) ) {
		            System.out.println("이미 존재하는 이름 입니다. 회원가입이 거부됩니다.");
		            return; // 회원가입 거부
		        }
		    }
		 //입력시 유효성검사,아이디
		 for (Member existingMember : memberList) {
		        if (existingMember != null && existingMember.id.equals(id) ) {
		            System.out.println("이미 존재하는 아이디 입니다. 회원가입이 거부됩니다.");
		            return; // 회원가입 거부
		        }
		    }

		
		me.id=id; me.pw=pw; me.name=name; me.phone=phone; me.age=age;
		
		//값 대입해주기
		for(int i= 0; i<memberList.length; i++) {//for start
			if(memberList[i]==null) {//if s
				memberList[i]=me;  System.out.println("회원가입 완료");
				break;}//if end
			}	//for end
		}
	  public void 로그인() {
		System.out.println("아이디:");			String id=scanner.next();
		System.out.println("비밀번호:");			String pw=scanner.next();
		boolean found=false;
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i] !=null) {
				if(memberList[i].id.equals(id)&&memberList[i].pw.equals(pw)) {
					System.out.println("로그인성공"); return;
				}
				
			
		}
		}
		if(!found) {
			System.out.println("아이디 또는 비밀번호가 일치하지않습니다.");
		}
	}	
	  
	  public void 아이디찾기() {
		System.out.println("이름");		String name=scanner.next();
		System.out.println("전화번호");	String phone=scanner.next();
		for(int i = 0 ; i<memberList.length ; i++) {
			if(memberList[i]!=null) {
				if(memberList[i].name.equals(name)&&memberList[i].phone.equals(phone)) {System.out.println(memberList[i].id);}
				else {System.out.println("등록된 아이디가없습니다.");}
			}
		}
	}
	  
	  public void 비밀번호찾기() {
		 System.out.println("아이디");	String id=scanner.next();
		System.out.println("전화번호");	String phone=scanner.next();
		for(int i = 0 ; i<memberList.length; i++) {
			if(memberList[i]!=null) {
				if(memberList[i].id.equals(id)&&memberList[i].phone.equals(phone)) {
					String randomString = UUID.randomUUID().toString().substring(0,4);
					memberList[i].pw=randomString;
					
					System.out.println("임시비밀번호:"+randomString);
				}
				else {System.out.println("동일한 아이디가없습니다.");}
				
			}
		}
		
	}
	@Override
	public String toString() {
		return "Member [scanner=" + scanner + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", age=" + age + "]";
	}
	
	
	


	
	
	//메소드
	
	
}
