package java1.day4;

import java.util.Scanner;

public class EX_2확인문제7 {
	
	public static void main(String[] args) {
		boolean run=true;
		int 예금액 =0;
		전체:while(run) {
		System.out.println("---------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("---------------------------------");
		Scanner scanner=new Scanner(System.in);
		System.out.print("선택>"); int sum=scanner.nextInt();
		
		if(sum==1) {
			System.out.println("예금액>");
			예금액 +=scanner.nextInt(); 
		}
		else if(sum==2) {
			System.out.println("출금액>");
			예금액-=scanner.nextInt();
		}
		else if(sum==3) {
			System.out.println("잔고>"+예금액);
		}
		else if(sum==4){System.out.println("프로그램종료");
				run=false;
		}
		
		}
		
			
	
	
	}
}
