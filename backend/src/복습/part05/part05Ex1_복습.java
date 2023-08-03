package 복습.part05;

import java.lang.reflect.Member;
import java.util.Scanner;

public class part05Ex1_복습 {
//실행클래스
		public static void main(String[] args) {
			EX1_복습member[] memberList = new EX1_복습member[100];
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("\n\n------------------회원시스템--------------");
				System.out.println("1.회원가입 2. 로그인 	선택>"); int ch=sc.nextInt();
				if(ch==1) {
					System.out.println("-------------회원가입-------------");
					System.out.println("아이디 : "); String InputId=sc.next();
					System.out.println("비밀번호 : "); String InputPw=sc.next();
					System.out.println("이름 : "); String InputName=sc.next();
					System.out.println("전화번호 : "); String InputPhone=sc.next();
					System.out.println("나이 : "); int inputAge=sc.nextInt();
					
					EX1_복습member member = new EX1_복습member(InputId,InputPw,InputName,InputPhone,inputAge);
					
					for(int i = 0 ; i<memberList.length ; i++) {
						if(memberList[i]==null) {
							memberList[i]= member;
							break;
						}
					}
					
				}
				else if(ch==2) {
					System.out.println("-----------로그인-----------");
					System.out.println("아이디 : "); String inputId=sc.next();
					System.out.println("비밀번호:"); String inputPw =sc.next();
					
					//로그인 여부를 저장하는 변수 -1
					int login = -1;
					for(int i = 0 ; i<memberList.length ; i++) {
						if(memberList[i]!=null&&
									memberList[i].id.equals(inputId)&&
											memberList[i].password.equals(inputPw)) {
							login=i;
							break;
						}
							
						
					}
					if(login>=0) {System.out.println("안내)로그인성공");}
					else {System.out.println("안내)로그인 실패");}
				}
			}
		}
}
