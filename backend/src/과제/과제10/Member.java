package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;

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
		Member me=new Member();
		System.out.println("아이디:"); 					String  id=scanner.next();
		System.out.println("비밀번호:");					String pw=scanner.next();
		System.out.println("이름:");						String name=scanner.next();
		System.out.println("전화번호:");					String phone=scanner.next();
		System.out.println("나이:");						String age=scanner.next();
		
		me.id=id; me.pw=pw; me.name=name; me.phone=phone; me.age=age;
		
		
		for(int s= 0; s<memberList.length; s++) {
			if(memberList[s]==null) {
				memberList[s]=me;
				break;
				
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
