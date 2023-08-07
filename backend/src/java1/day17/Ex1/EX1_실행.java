package java1.day17.Ex1;

public class EX1_실행 {
	
	public static void main(String[] args) {
		
		//?? 하나밖에 안된다는 뭐지? class(상속) 와 interface차이점!(상속이 하나!!)
		
		//1. 인터페이스타입의 변수 선언
		RemoteControl rc;
				// * 인터페이스 만으로 객체 생성 불가능 [ 객체 생성할려면 추상메소드를 구현후 가능]
		
		//2. 인터페이스 변수에 텔리비전객체의 대입[ 주소대입 ]
		rc= new Television();	
		// 구현 객체 : 추상메소드가 존재한 인터페이스를 구현해준 클래스로 객체 생성
		//3. 인터페이스로 메소드 실행
		rc.turnOn();
		//4. 리모컨을 오디오 변경
		rc= new Audio();
		//5. 오디오 메소드 실행
		rc.turnOn();
		
		//5. 리모콘의 상수필드 호출
		System.out.println("리모콘의 최대 볼륨 " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘의 최소 볼륨 " + RemoteControl.MIN_VOLUME);
		
		//6. 메소드 실행
		rc.setVolume(100);
		
		//7. 리모콘 교체
		rc = new Television();
		
		rc.setVolume(-10);
		/* 
		 	인터페이스 			vs			 상속
		 	implements					extends
		 	구현하다						연장하다
		 	여러개 구현						1개 상속
		 	추상메소드						메소드
		 	*버전[다양한 메소드 제공]			
		 목적: 메소드 통합  					빠른 개발/ 설계 모듈화[쪼개서]
		     게임패드						직급별사원
		     
		 */
	}
}
