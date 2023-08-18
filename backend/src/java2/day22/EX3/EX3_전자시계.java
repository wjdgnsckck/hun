package java2.day22.EX3;


import java.util.Scanner;

public class EX3_전자시계 {

	public static void main(String[] args) {
		//[현재시간기능 스레드] 자동으로 현재시간 실행
		현재시간 현재시간 =new 현재시간();
		Thread thread =new Thread(현재시간);
		thread.start();
		
		//[main스레드] 타이머 사용여부 선택받아 실행
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 타이머 시작 2.타이머 중지 :");
			int ch = sc.nextInt();
			if(ch==1) {System.out.println("타이머 시작");
			타이머 타이머 =new 타이머();
			Thread thread2 =new Thread(타이머);
			thread2.start();
			}
			else if(ch==2) {System.out.println("타이머 종료");}
		}
	}
}
