package 과제3.Level2.if문제;

import java.util.Scanner;

public class if문제 {
		
	public static void main(String[] args) {
		

		/* -------문제1----- */
		Scanner scanner =new Scanner(System.in);
		System.out.println("정수를입력하시오"); int 정수=scanner.nextInt();
		System.out.println("정수를입력하시오"); int 정수2=scanner.nextInt();
		int max=0;
		int min=0;

		if(정수>정수2) {
			max=정수; min=정수2;
			System.out.println("큰수:"+max);
			System.out.println("작은수:"+min);
			if(정수<정수2) {
				max=정수2 ;min=정수;
				System.out.println("큰수:"+max);
				System.out.println("작은수:"+min);
				
			}
		}else {System.out.println("같은수입니다.");}
		
		/* -------문제2----- */
		System.out.println("정수3를입력하시오"); int 정수3=scanner.nextInt();
		System.out.println("정수4를입력하시오"); int 정수4=scanner.nextInt();
		System.out.println("정수5를입력하시오"); int 정수5=scanner.nextInt();
		int max2=정수3;
		if(max2<정수4) {
			max2=정수4;
		}else if(max2<정수5) {max2=정수5;}
		
		System.out.println("가장큰수는:"+max2);
		
		/* -------문제3----- */
		
		/* -------문제4----- */
		System.out.println("점수를입력하시오"); int 정수7=scanner.nextInt();
		if(정수7>=90) {
			System.out.println("합격입니다.");
		}else {System.out.println("불합격입니다.");}
		/* -------문제5----- */
		System.out.println("점수를입력하시오"); int 정수8=scanner.nextInt();
		if(정수8>=90) {
			System.out.println("A등급");
		}else if(정수8>=80) {
			System.out.println("B등급");
		}else if(정수8>=70) {
			System.out.println("C등급");
		}else {System.out.println("재시험");}
		
		/* -------문제6----- */
		System.out.println("국어점수를입력하시오"); int 국어=scanner.nextInt();
		System.out.println("영어점수를입력하시오"); int 영어=scanner.nextInt();
		System.out.println("수학점수를입력하시오"); int 수학=scanner.nextInt();
		int avg2 = 국어+영어+수학;
		if(avg2>=90&&국어==100) {
			System.out.println("국어 우수");
			if(avg2>=90&&영어==100) {
				System.out.println("영어우수");
				if(avg2>=90&&수학==100) {
					System.out.println("수학우수");
				}
			}
		}else if(avg2>=80&&국어>=90) {
			System.out.println("국어장려");
			if(avg2>=80&&영어>=80) {
				System.out.println("영어장려");
				if(avg2>=80&&수학>=80) {
					System.out.println("수학장려");
				}
			}
		}else {System.out.println("재시험");}
		/* -------문제7----- */
		System.out.println("아이디를입력하시오"); String 아이디=scanner.next();
		System.out.println("비밀번호를입력하시오"); String 비밀번호=scanner.next();
		if(아이디.equals("admin")&&비밀번호.equals("1234")) {
			System.out.println("로그인성공");
		}else {System.out.println("로그인실패");}
	}
}



/*
 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]

 문제5 : 
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//				점수가 80점 이상이면 B등급
		//				점수가 70점 이상이면 C등급
		//				그외 재시험


 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
		[ 입력 ] : 국어,영어,수학 입력받기
		[ 조건 ]
			평균이 90점 이상이면서 
				국어점수 100점 이면 '국어우수' 출력
				영어점수 100점 이면 '영어우수' 출력
				수학점수 100점 이면 '수학우수' 출력
			평균이 80점 이상이면서 
				국어점수 90점이상 이면 '국어장려' 출력
				영어점수 90점이상 이면 '영어정려' 출력
				수학점수 90점이상 이면 '수학장려' 출력
			그외 재시험 
	 
문제7 로그인페이지
		[ 입력 ] : 아이디와 비밀번호를 입력받기
		[ 조건 ] : 회원아이디가 admin 이고 
          			비밀번호가 1234 일 경우에는 
         			로그인 성공 아니면 로그인 실패 출력
*/

