package 과제.과제2.Level1;

import java.util.Scanner;

public class 연습 {
		public static void main(String[] args) {
	

	//정수 하나를 입력 받아서 /2했을때 그 값을 반올림하여 출력하시오. 단,라이브러리 금지
     Scanner sc = new Scanner(System.in);
     float a =sc.nextFloat();
     
     //여기서부터//
     float b = a/2;		//입력값 %2
     int d = (int)b;
     float c = (10*b)%10 >= 5 ? d+1 : d;
     //여기까지 수정 가능
     
     System.out.println(c);
       
   
       
}
}
