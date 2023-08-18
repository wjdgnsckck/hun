package java2.day22;

import java.awt.Toolkit;

public class Ex1_멀티스레드 {	// 메인스레드가 main메소드를 호출하면서 코드 시작
	public static void main(String[] args) {
		
		System.out.println("싱글스레드 시작");
		
	
	
	//p.596 예1
	Toolkit toolkit = Toolkit.getDefaultToolkit();	//java.awt=JAVAUI제공
	for(int i = 0 ; i<5 ; i++) {toolkit.beep();}	// . beep();비프음
	
	//*
	for(int i = 0 ; i<5; i++) {
		
		toolkit.beep();
		//* 0.5초간 딜레이 [ 메인스레드 잠깐 멈춤 ] - 밀리초(1/1000)초s
		try{Thread.sleep(500);}catch (Exception e) {
			System.out.println(e);
		}
	}
	//*5번의 출력
	for(int i =0;i<5;i++) {
		System.out.println("띵");
		try {Thread.sleep(500);}catch (Exception e) {
			System.out.println(e);
		}
	}
	//---------------------------------------------------------//
	System.out.println("멀티스레드 시작[익명구현체]");
	//-----------------------------멀티 스레드 [익명구현체]-------------------------//
	//1. main스레드와 작업스레드 객체 만들기
	Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() { //Runnable인터페이스 추상메소드 구형
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for(int i = 0 ; i<5; i++) {
				
				toolkit.beep();
				//* 0.5초간 딜레이 [ 메인스레드 잠깐 멈춤 ] - 밀리초(1/1000)초s
				try{Thread.sleep(500);}catch (Exception e) {
					System.out.println(e);
				}
			}
		} //추상메소드 end
	});//생성자 end
	
	
	//2.작업스레드 시작
	thread.start();
	//3.main스레드 작업
	for(int i =0;i<5;i++) {
		System.out.println("띵");
		try {Thread.sleep(500);}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	System.out.println("멀티스레드 시작 [구현체] ");
	//-------------------------------1.멀티 스레드 [구현체]---------------------------//
	비프음 비프음=new 비프음();
	Thread thread2 = new Thread(비프음);
	thread2.start();
	//---------------------------------------------------------//
	System.out.println("멀티스레드 시작[Therad 자식 클래스]");
	//-----------------------------멀티 스레드 [익명구현체]-------------------------//
	비프음2 비프음2 =new 비프음2() {};
	비프음2.start();
	//3.main스레드 작업
		for(int i =0;i<5;i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) {
				System.out.println(e);
			}
		}
	}//  main end
	

}
/*
	프로그램 : 명령문의 집합
		- 프로세스 : 실행중인 프로그램
		- 멀티태스킹 : 두 가지 이상의 작업을 동시 처리
		- 멀티프로세스 : 운영체제는 동시에 여러개 프로세스 생성해서 처리

		*멀티프로세스가 프로그램 단위의 멀티 태스킹
		*멀티스레드는 프로그램 *내부 에서의 멀티 태스킹
		
		
		- 멀티프로세스 서로 독립적이다.
			-한글프로그램(프로세스), 엑셀프로그램(프로세스) 동시에 사용시 한글에서 오류가 발생하더라도 엑셀은 무관하다
		- 멀티스레드에서는 하나의 스레드가 오류 발생하면 프로세스 종료되므로 영향 미친다.
			-카카오톡 (프로세스[채팅기능/스레드,파일전송기능/스레드])
				파일전송 스레드에서 오류가 발생하면 카카오톡 프로세스 종료되므로 채팅도 같이 종료
				
		멀티스레드 : 병렬로 데이터 처리하는 곳
			1. 사용처 : 앱, 웹 서버 등등
			2. 메인스레드 : 모든! 자바 프로그램 메인스레드가 main메소드를 실행하면서 시작된다.
			3.
				싱글스레드 : main메소드만 사용하는 경우 [*메인스레드가 종료되면 프로세스 종료]
				멀티스레드 : main메소드에 새로운 작업스레드를 생성하는 경우 [*모든스레드가 종료되면 프로세스 종료]
			4. 작업 스레드 생성
				1. Therad 클래스로 직접 생성
					1.Thread 변수명 = new Thread( Runnable구현객체 );
					-start() : run 메소드 호출
			5. 
				Runnable : 스레드가 작업을 실행할때 사용하는 인터페이스
					- run () : [추상메소드] 작업스레드 실행 코드 정의
			6.익명[이름없는]객체
				익명구현체
					클래스명 클래스 = new 클래스명 () { 오버라이딩메소드 }
				익명구현체
					클래스명 클래스 = new 클래스명(new 인터페이스명(){ 오버라이딩메소드 })
					비프음2 비프음2 =new 비프음2() {public void run() {};}; 예제!
					
 */