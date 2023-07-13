package java1.day01;

public class EX_2타입 {
	
	public static void main(String[] args) {
		
		int var1 =0b1011;	//(2진수) 데이터 앞에 0b 
		System.out.println(var1);
		int var2 =0206;		//(8진수) 데이터 앞에0
		System.out.println(var2);
		int var3 =365;
		System.out.println(var3);
		int var4 =0xB3;		//(16진수) 데이터 앞에0x
		System.out.println(var4);
		
		
		
		
		
	
		
		/*
		 
		 타입/자료형 : 데이터 저장할때 사용되는 메모리 크기
		 	1.메모리 효율성 높일수 있다.
		 	2.가독성 높음
							메모리크기 					허용범위
		 	논리타입
		 	문자타입
		 		char			2바이트			[0~65535]유니코드
		 	*문자열=기본타입X
		 			String		클래스[글자수다름] 제한없음.
		 	정수형타입
		 			byte		1바이트				[-128~127] 대략 +-100
		 			short		2바이트				[-32,768~32,767]대력+-30000
		 			int			4바이트				[대략 21억]
		 			long		8바이트				[대략 21억]
		 	실수타입
		 		float 			4바이트							소수점 8자리 표현
		 		double		8바이트							소수점 17자리 표현
		 		//용량 단위:
		 		 * 0,1 -> 1bit		->01010101 ->8bit -> 1byte
		 		 * 1byte - > 1024byte -> 1kb 
		 		 * 1kb - >1024kb-> 1mb
		 		 * 1mb ->1024mb ->1gb
		 		 *
		 		 
		 // 인코딩 : 2진수를 문자로 표하는 방법
		   		
		   		아스키코드:7비트(확장8비트) ->128문자 표현 1바이트=특수문자/숫자/영문
		   		유니코드:전세계 공용어 
		 */
		
		//[p.42 ] byte 타입 [-128~127]
		byte b1 = -128; System.out.println("b1 :" +b1);
		byte b2 = 127; System.out.println("b2 : " +b2);
		
							//byte b3 = 300; System.out.println("b3 :" +b3);// 오류 :허용범위 벗어남
		//short 타입 [-32,000~32,000]
		short s1 =3200; System.out.println("s1 :"+s1);
		//short s2 = -50000; System.out.println("s2:"+s2);
		
		//int 타입[대략 +=21억정도] *정수 기본타입 : 1. 우리 코드로 적은 숫자
		int i1=2000000000; System.out.println("i1:"+i1);
		//int i2=20000000000; System.out.println("i2:"+i2);
		
		//long 타입 [대략 +- 21억이상 자동] 1000경
		long l1=10; System.out.println("l1:"+l1);
		//long l2=3000000000; System.out.println("l2:"+l2);//직접 작성한 정수 30억은 int
		long l3=3000000000L; System.out.println("l3:"+l3);//직접 작성한 정수를 long 타입 변경 ->정수 뒤에 L 붙이기
		
		//[p.43]char 타입 [문자 1개 저장]
		char c1='A' ;  System.out.println("c1 : "+c1); //문자 : '  ' VS 문자열 :" "
		char c2=65 ;  System.out.println("c2 : "+c2); 
		char c3='가' ;  System.out.println("c3 : "+c3); 
		char c4=44032;  System.out.println("c4 : "+c4); 
		
		//String 클래스[문자열 저장] " "
		String str1 = "안녕하세요"; System.out.println("str1:"+str1);
		
		//실수 float 타입 [소수 8자리 표현]
		float f1 = 0.123456789123456789f; System.out.println("f1:"+f1);
		//double	[소수점 17자리 표현]
		double d1 =0.123456789123456789;System.out.println("d1:"+d1);
		
		//boolean 타입 [true of false]
		boolean bool1 = true ; System.out.println("bool1 :" + bool1);
		
		// 제어/이스케이프(기능)문자
			//\" : "출력			\` : 출력 		\\:\출력
			// \t :들여쓰기   		\n: 줄바꿈 	\r : 캐리지 리턴[커서 맨앞으로]
			//\n\r :엔터
		System.out.println("\''");
		System.out.println("\'");
		System.out.println("\\");
		System.out.println("\t띄어쓰기");
		System.out.println("\n줄바꿈");
		System.out.println("\r캐리지 리턴");
	}

}
