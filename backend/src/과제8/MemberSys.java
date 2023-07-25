package 과제8;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행
public class MemberSys {
	public static void main(String[] args) {
		
		//0. 여러개 Member객체 100개=100명을 저장 예정인 객체  저장하는 배열 선언
		Member[] memberList = new Member[100];
		// 배열 선언: 타입명[] 배열명 = new 타입명[길이];
						//타입 : 기본타입(int.float 등),참조(String,직접만든클래스=Member)타입
		Scanner sc=new Scanner(System.in);
		while(true) {//w s
				//1. 무한 출력
				System.out.println("\n\n----------회원 시스템------------");
				System.out.print("1.회원가입 2.로그인     선택>");
				int ch=sc.nextInt();  	//2. 무한 입력
				
				//3. 입력/선택 경우의수
				if(ch==1) {
					System.out.println();
					System.out.println("-----------회원가입--------------");
						//1. 각 입력받아 저장
					System.out.println("아이디:"); String inputId=sc.next();
					System.out.println("비밀번호:"); String inputPw=sc.next();
					System.out.println("이름:"); String inputName=sc.next();
					System.out.println("전화번호:"); String inputPhone=sc.next();
					System.out.println("나이:");  int inputAge=sc.nextInt();
					//2.
						//1. 기본생성자[과제용]vs 정의한생성자[과제9]
					//1안
					Member member=new Member(inputId,inputPw,inputName,inputPhone,inputAge);
					
				
						//2. 5가지를 하나로 묶음 = 문자열vs객체
						//* 객체선언 : 클래스명 객체변수명 = new 생성자명();
					
					//3. 여러개의 객체를 저장하기 위해 배열에 저장
						//* 비어있는인덱스=기본값인덱스
					for(int i=0 ; i<memberList.length;i++) {
						// 만약에 i번째 인덱스에 null 이면 해당 i번째 인덱스에 입력받아서 만든 데이터 대입
						if(memberList[i]==null) {memberList[i]=member;break;}
					}	//for end
					
					
										//
				}
				else if(ch==2) { //if start
					System.out.println("------------로그인----------------");
						//1. 입력받기
					System.out.println("아이디:"); String inputId=sc.next();
					System.out.println("비밀번호:"); String inputPw=sc.next();
						
						//2.입력받은 데이터를 배열내 찾기
					int login=-1;	//로그인 여부를 저장하는 변수 -1 : 못찾았다 0이상이면 찾고 인덱스번호 저장=로그인성공 기록
					for(int i = 0 ; i<memberList.length; i++) {
						if(	memberList[i]!=null	&& //비어 있는 인덱스는 검사할 필요가 없다.
								memberList[i].id.equals(inputId)&&
									memberList[i].password.equals(inputPw)) {
							login=i;//로그인 성공후 변수에 성공한 인덱스 저장 = 추후에 로그인 상태 활용
							break;
						}
						
					}//for end
					
					//3. 로그인 성공여부 변수에 따른 흐름 제어
					//로그인 실패[ 모든 배열 검사후에 성공 못하면 실패 ]
					if(login>=0) {System.out.println("로그인성공");}	//추후에 로그인시 새로운 메뉴 메소드 호출
					else {System.out.println("안내) 로그인실패");}
				}	//if end
				
		}// w e
				
	}
}

