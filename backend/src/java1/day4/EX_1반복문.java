package java1.day4;

import java.util.Scanner;

public class EX_1반복문 {// class start
	public static void main(String[] args) {//main start
		
		int sum=0;
		sum=sum+1; sum=sum+2; sum=sum+3;sum=sum+4;
		
		int sum2=0;
		for (int i = 1 ; i<=10 ; i++) {
			sum2+=i;
		}
		System.out.print(1);System.out.print(2);System.out.print(3);
		System.out.print(4);System.out.print(5);System.out.print(6);
		System.out.print(7);System.out.print(8);System.out.print(9);System.out.println(10);
		for(int i=1 ; i<=10 ; i+=1) {System.out.print(i + "  ");}
		
		
		int sum3=0;
		for(int 반복변수 =1; 반복변수 <=100 ; 반복변수++) {	sum +=반복변수; }
		//System.out.println(반복변수); // x=for ()에서 선언된 변수는 for{}밖에서 사용불가
		int sum4=0; int i ;
		for(i=1 ; i<=100 ; i++) { sum4+=i;}
		System.out.println("1~" + (i-1) + "합:" + sum4);
		
		//소수점뒤에 f 사용이유 : (직접 작성한 소수점)리터럴 소수점 =double 
		for(float x=0.1f; x<=1.0f ; x+=0.1f) {System.out.println(x);}
		System.out.println("-------------------------------------------");
		for(double x=0.1; x<=1.0 ; x+=0.1) {System.out.println(x);}
		//구구단
		for(int m=2 ; m<=9 ; m++) {
			System.out.println("***"+m+"단***");
			for(int n=1 ; n<=9 ; n++) {
				System.out.println(m+"x"+n+"="+(m*n));
			}
		}
		
		int a = 1 ; 
		while(a<=10) {System.out.println(a+""); a++;}
		
		int sum5=0;
		int b=0;
		while(b<=100) {sum5+=b;b++;}
		
		//while(true) {System.out.println("무한반복");}
		//for(;;) {System.out.println("무한반복");}
		
		Scanner scanner =new Scanner(System.in);
		boolean run = true ;  
		int speed=0;
		while(run) {
		
			System.out.println("---------------------");
			System.out.println("1. 증속 | 2.감속 | 3.중지");
			System.out.println("---------------------");
			System.out.println("선택");
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")) {
				speed++;
				System.out.println("현재 속도 ="+speed);
			}else if(strNum.equals("2")) {
				speed--;
				System.out.println("현재 속도 ="+speed);
			}else if(strNum.equals("3")) {
				run=false;
				
			}
			
		}
			대문자for:for(char upper ='A'; upper <='Z';upper++) {
				System.out.print(upper+"");
				소문자for:for(char lower='a';lower<='z';lower++) {
				System.out.print("\t"+lower);	
				if( lower == 'g' )break 대문자for;
				}
				System.out.println();
			}
		숫자for:for(int j=1 ; j<=10; j++) {
			if(j%2 !=0) {
				continue 숫자for;
			}
			System.out.println(j+" ");
		}
		
		
			
	
	}//main end
		
}//class end
/*
 	for문 
 	for (1.초기값 ;2. 조건식;4.증감식){
 			3.실행문;
 	}
 	
 	1.초기값이 실행된다.
 	2.조건식 판단해서 true이면 {}들어감,false{}건너뜀/종료
 	3.true이면 실행문 실행
  
 */