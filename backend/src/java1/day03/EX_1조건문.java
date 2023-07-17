package java1.day03;

import java.util.Random;

public class EX_1조건문 {	//class s
		
		public static void main(String[] args) {		//main start
			
			
			//1.[p.114]
			int score=75;
			if(score>=90) {
				System.out.println("점수가 100~90입니다.");
				System.out.println("등급은 A입니다.");
			}else if(score>=80) {
				System.out.println("점수가 80~89입니다.");
				System.out.println("등급은 B입니다.");
			}else if(score>=70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
			}else {
				System.out.println("점수가 70미만입니다.");
				System.out.println("등급은 D입니다.");
			}
			
			//[ p.115] 난수생성: Mate.random()	
			System.out.println( Math.random());	//0.0<=~<1.0
			System.out.println( Math.random()*6); //0.0<~=<~6.0
			System.out.println( (int)(Math.random()*6));	//0<~=<6 
			System.out.println( (int)(Math.random()*6)+1);	//1<~=<7
			//정수 난수공식 :(int)(Math.random()*n)+s
				//s : 난수 시작번호 						n : 난수 개수
			//예시) 1~45
			System.out.println((int)(Math.random()*45)+1);
			//---------------------------------------vs-----------------------------
			// 난수 생성 클래스 : 	Random 클래스
				//1.Random 객체 생선한다. // 2. 랜덤 값 호출
			Random random=new Random();
			System.out.println(random.nextInt());
			System.out.println(random.nextInt(3));
			//random.nextInt(개수)
			System.out.println(random.nextInt(6)+1);
			System.out.println(random.nextInt(45)+1);
			//예시 )a-z
			System.out.println( (char)(random.nextInt(26)+97) );
			
			//[p.116] 주사위 예제
			int num =(int)(Math.random()*6)+1;	//1~6
			//int num2=random.nextInt(6)+1;			//1~6
			
			if(num==1) {
				System.out.println("1번이 나왔습니다.");
			}else if(num==2) {
				System.out.println("2번이 나왔습니다.");
			}else if(num==3) {
				System.out.println("3번이 나왔습니다.");
			}else if(num==4) {
				System.out.println("4번이 나왔습니다.");
			}else if(num==5) {
				System.out.println("5번이 나왔습니다.");
			}else {System.out.println("6번이나왔습니다.");}
			//---------------------------vs---------------
			//[p.119]주사위 예제 =switch
			switch(num) {
				case 1 :System.out.println("1번이 나왔습니다.");
					break;
				case 2:System.out.println("2번이나왔습니다.");
					break;
				case 3:System.out.println("3번이나왔습니다.");
					break;
				case 4:System.out.println("4번이나왔습니다.");
					break;
				case 5:	System.out.println("5번이나왔습니다.");
					break;
				default:System.out.println("6번이나왔습니다.");
			}
			
			/*if = 조건에 따른 true / false 실행
			 	-경우의 수 의 값이 정해져 있지 않는 경우(정해져도 가능하다.)/ 범위 논리o
			 switch=변수 값에 따른 진행
			 	-경우의 수 의 값이 정해져 있는 경우 / 범위 논리 x
			 	-break ; : 만약에 해당 case 실행후 멈춤(switch는 참의 값을 찾아도 계속 돈다)
			*/
			
			//[p.121]
			char grade2='B';
			switch(grade2) {
			case 'A':
			case 'a':
				System.out.println("우수 회원입니다.");
				break;
			case'B':
			case'b':
				System.out.println("일반 회원입니다.");
				break;
			default:
				System.out.println("손님입니다.");
			}
		}	//main end
	
}//class end
/*
 
 
 
	if : 만약에 조건에 따른 흐름 제어
		형태
			1.if(조건식) 실행문;
 

 */



