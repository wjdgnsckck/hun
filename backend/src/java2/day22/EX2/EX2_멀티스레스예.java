package java2.day22.EX2;

public class EX2_멀티스레스예 {
	public static void main(String[] args) {
		// -- 스레드 현황 : [main] -싱글스레드
		//1.main스레드가 작업스레드1 객체 생성
		작업스레드1 작업스레드1=new 작업스레드1();	//구현객체 생성
		Thread thread = new Thread(작업스레드1);	//구현객체를 Thread에 전달
		//1. 작업스레드1 객체에서 작업스레드 시작
		thread.start();		
		
		//2. main스레드가 작업스레드2 객체 생성
		작업스레드2 작업스레드2 = new 작업스레드2();
		//2. 작업스레드2 객체에서 스레드 시작
		작업스레드2.start();
		//3.main스레드가 1초 마다 출력
		try {	
			int count = 1;
			while(true) {Thread.sleep(1000);	//1초간 일시정지 [예외처리필수]
				System.out.println(Thread.currentThread().getName()+ "[main Therad] output :" + count);
			// 현재 스레드의 이름 호출 :Thread.currentThread().getName()
			// 현재 스레드의 이름을 변경 : Thread.currentThread().setName("새로운이름");
			count ++;
		
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
