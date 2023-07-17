package 과제.과제2.Level1;

import java.util.Scanner;	//scanner 클래스를 사용하기 위한 클래스 호출

public class 연산20문제 {
	
	public static void main(String[] args) {
		
				//------ 문제1 여기에 풀이-------//
		System.out.println("---------------문제1-------------");
		
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//------ 문제2 여기에 풀이-------//
		System.out.println("---------------문제2-------------");
		//입력
			//1. 입력객체 생성{ } 마다 하나의 객체 필요
		Scanner scanner=new Scanner(System.in);
			//2. 입력객체로부터 입력받은 데이터 호출하기 /저장
		 System.out.print("작성자 :");  String 작성자 =scanner.next();
		 System.out.print("내용 :");  String 내용 =scanner.next();
		 System.out.print("날짜 :");  String 날짜 =scanner.next();
		 //출력
		 		System.out.println("----------------방문록------------");
		 		System.out.println("l 순번 ㅣ 작성자 ㅣ   내용 ㅣ   날짜 ㅣ ");
		 		System.out.println("l "+1+" ㅣ "+작성자+" ㅣ  "+ 내용+" ㅣ  "+ 날짜+" ㅣ ");
		 		System.out.println("------------------------------------");
		/*문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
		[입력변수]
			1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
		[출력 예]
			   --------------방문록--------------------
			   | 순번  | 작성자  | 	내용 	| 날짜       |
			   |  1   | 강호동  |안녕하세요  |  09-28    |
			  ----------------------------------------*/
		//------ 문제3 여기에 풀이-------//
		 	System.out.println("---------------문제3-------------");
		 	//1. 입력
		 		//1. 입력객체 :상단에
		 		//2. 입력값 호출
		 System.out.println("기본급:");       int 기본급 =	scanner.nextInt();
		 System.out.println("수당:");       int 수당 =	scanner.nextInt();
		 //2.계산
		 int 실수령액 = 기본급 + 수당 - (int)(기본급*0.1);
		 //3.출력
		 System.out.println("실수령액:"+실수령액);
		/*문제3 : 급여 계산
		[입력조건]
			기본급[정수] , 수당[정수]
		[ 조건 ] 
			 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
		[출력조건] 
			실수령액 출력[ 소수점 없이  ]*/
		//------ 문제4 여기에 풀이-------//
	System.out.println("---------------문제4-------------");
	
	System.out.println("지폐를 넣어주세요:");	   int 금액=scanner.nextInt();
	//십만원
	System.out.println("십만원:"+(금액/100000)+"장");
	//만원
	금액 -= (금액/100000) *100000;	//원금에서 위에 십만원 단위 제외
	System.out.println("만원:"+(금액/10000)+"장");
	//천원
	금액 -= (금액/10000)* 10000;	//원금에서 위에 만원단위 제외
	System.out.println("천원:"+(금액/1000)+"장");
	//백원
	금액 -= (금액/1000)* 1000;	//원금에서 위에 천원단위 제외
	System.out.println("백원:"+(금액/100)+"개");
	//!!!!!
	//쉬운 방법 String.valueOf(금액).charAt(1);
		
		//------ 문제5 여기에 풀이-------//
	System.out.println("---------------문제5-------------");
		System.out.println("정수를입력하시오:");    int 정수5=scanner.nextInt();
		System.out.println(정수5%7==0 ?"O":"X");
		
		//------ 문제6 여기에 풀이-------//
		System.out.println("---------------문제6-------------");
		System.out.println("정수를입력하시오:");    int 정수6=scanner.nextInt();
		System.out.println(정수6%2==1 ?"O":"X");
		//------ 문제7 여기에 풀이-------//
		System.out.println("---------------문제7-------------");
		System.out.println("정수를입력하시오:");    int 정수7=scanner.nextInt();
		System.out.println(정수7%7==0 && 정수7%2==0? "O":"X");
		//------ 문제8 여기에 풀이-------//
		System.out.println("---------------문제8-------------");
		System.out.println("정수를입력하시오:");    int 정수8=scanner.nextInt();
		System.out.println(정수8%7==0 || 정수8%1==0? "O":"X");

		//------ 문제9 여기에 풀이-------//
		System.out.println("---------------문제9-------------");
		System.out.println("정수를입력하시오.");int 정수9=scanner.nextInt();
		System.out.println("정수를입력하시오.");int 정수10=scanner.nextInt();
		System.out.println(정수9>정수10? 정수9:정수10);
		//------ 문제10 여기에 풀이-------//
		System.out.println("---------------문제10-------------");
		System.out.println("반지름을 입력하시오:");int 반지름= scanner.nextInt();
		double 원주율 = 3.14;
		System.out.println("원 넓이 : "+반지름*반지름*원주율);
		
		//------ 문제11 여기에 풀이-------//
		System.out.println("---------------문제11-------------");
		System.out.println("실수1:"); double 실수1=scanner.nextDouble();
		System.out.println("실수2:"); double 실수2=scanner.nextDouble();
		System.out.printf("실수2에서 실수1비율 계산:%.6f %% \n",(실수1/실수2) * 100.0);
		
		//------ 문제12 여기에 풀이-------//
		System.out.println("---------------문제12-------------");
		System.out.println("윗변을 입력하시오:");   int 윗변=scanner.nextInt();
		System.out.println("밑변을 입력하시오:");   int 밑변=scanner.nextInt();
		System.out.println("높이를 입력하시오:");   int 높이=scanner.nextInt();
		System.out.println("사다리꼴 넓이:"+(윗변+밑변)*높이/2);
		//------ 문제13 여기에 풀이-------//
		System.out.println("---------------문제13-------------");
		System.out.println("키를입력하시오:"); int 키=scanner.nextInt();
		System.out.println("표준체중:"+(키-100)*0.9);
		
		//------ 문제14 여기에 풀이-------//
		System.out.println("---------------문제14-------------");
		System.out.println("키를입력하시오:"); int 키2=scanner.nextInt();
		System.out.println("몸무게를입력하시오:"); int 몸무게=scanner.nextInt();
		System.out.println("BMI:"+(몸무게 / ( (키2/100)*(키2/100))));
		//------ 문제15 여기에 풀이-------//
		System.out.println("---------------문제15-------------");
		System.out.println("inch를 입력하시오."); double 인치 =scanner.nextDouble();
		System.out.println("inch:"+인치*2.54+"cm");
		
		//------ 문제16 여기에 풀이-------//
		System.out.println("---------------문제16-------------");
		System.out.println("중간고사:"); int 중간고사 =scanner.nextInt();
		System.out.println("기말고사:"); int 기말고사 =scanner.nextInt();
		System.out.println("수행평가:"); int 수행평가 =scanner.nextInt();
		System.out.printf("반영비율:%.2f  \n", (중간고사*0.3+기말고사*0.3+수행평가*0.4));
		
		
		//------ 문제17 여기에 풀이-------//
		System.out.println("---------------문제17-------------");
		int x=10;			//x=10 대입
		int y =x-- +5 +--x;	
		System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
			//x=8 , y=23;
		
		//------ 문제18 여기에 풀이-------//
		System.out.println("---------------문제18-------------");
		System.out.println("나이를입력하시오:"); int 나이=scanner.nextInt();
		System.out.println(나이>=40 ? "중년" : 나이>= 20  ? "성인" : 나이>=10 ? "학생":"유아");
		//앞으로 조건을 주면 앞에서 다 가져가니 뒤에서 부터 시행해야 한다(다 참이기 때문이다.)
		//------ 문제19 여기에 풀이-------//
		System.out.println("---------------문제19-------------");
		System.out.println("국어점수입력:"); int 국어=scanner.nextInt();
		System.out.println("영어점수입력:"); int 영어=scanner.nextInt();
		System.out.println("수학점수입력:"); int 수학=scanner.nextInt();
		System.out.println("총점:"+(국어+영어+수학));
		System.out.println("평균:"+(국어+영어+수학)/3);
		//------ 문제20 여기에 풀이-------//
		System.out.println("---------------문제20-------------");
		System.out.println("아이디를 입력하시오:"); String 아이디=scanner.next();
		System.out.println("비밀번호를 입력하시오:"); String 비밀번호=scanner.next();
		System.out.println(아이디.equals("admin")&& 비밀번호.equals("1234")? "로그인성공":"로그인실패");
		//* 비교/산술 연산자는 객체에서 사용 불가능[ 기본타입vs객체 메모리 구조가 다르다]
		// 문자열은 ==으로 비교할수 없다. // equals 를 사용해야한다.
		//------ 문제21 여기에 풀이-------//
		System.out.println("----------------문제21-------------");
		System.out.println("정수1:") ; int 정수1 =scanner.nextInt();
		System.out.println("정수2:") ; int 정수2 =scanner.nextInt();
		System.out.println("정수3:") ; int 정수3 =scanner.nextInt();
		int max = 정수1 ; // 임의의 가장 큰수를 저장하는 max 변수
		max= max<정수2 ? 정수2:max;
		max= max<정수3? 정수3:max;
		System.out.println("max : "+max);
	}

	
	
	
	/*

	문제1 : 강아지 console 출력
		|\_/|
		|q p|   /}
		( 0 )"""\
		|"^"`    |
		||_/=\\__|

	문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
		[입력변수]
			1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
		[출력 예]
			   --------------방문록--------------------
			   | 순번  | 작성자  | 	내용 	| 날짜       |
			   |  1   | 강호동  |안녕하세요  |  09-28    |
			  ----------------------------------------
		
	문제3 : 급여 계산
		[입력조건]
			기본급[정수] , 수당[정수]
		[ 조건 ] 
			 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
		[출력조건] 
			실수령액 출력[ 소수점 없이  ]

	문제4 : 지폐 세기 
		 [입력조건 ] 
			금액 
		 [조건 ] 
			 십만원 부터 백원 까지의 개수 세기 
		[ 출력조건 ]
			예) 356789 입력시 
			 십만원 3장 	//입력값 / 100000 출력("장")
			 만원 5장		//입력값 /10000출력("장")
			 천원 6장 		//입력값 / 1000출력("장")
			 백원 7개		//입력값 /100 출력("개")

	문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

	문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

	문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

	문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

	문제9 : 두개의 정수를 입력받아 더 큰수 출력 

	문제10 : 반지름을 입력받아 원 넓이 출력하기 
		계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

	문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
		예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

	문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
		계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

	문제13: 키를 정수를 입력받아 표준체중 출력하기 
		계산식) 표준체중 계산식 = > (키 - 100) * 0.9

	문제14: 키와 몸무게를 입력받아 BMI 출력하기 
		계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

	문제15: inch 를 입력받아 cm 로 변환하기 
		계산식) 1 inch -> 2.54cm

	문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
		계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

	문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
		int x = 10;
		int y = x-- + 5 + --x;
		printf(" x의 값 : %d , y의값 :  %d ", x, y)

	문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

	문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

	문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

	문제21 : 세 정수를 입력받아 가장 큰수 출력 

	  
	 */

}
