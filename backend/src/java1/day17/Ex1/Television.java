package java1.day17.Ex1;

// 클래스에서 인터페이스를 구현하기
public class Television implements RemoteControl {
	
	private int volume;//인스턴스 필드
	
	//추상메소드 구현 : implements 인터페이스명 을 하게 되면 해당 인터페이스의 추상 메소드를 모두 구헌
	@Override
	public void turnOn() {
		// 클래스명 implements 인터페이스명
		// 인터페이스가 선언한 추상메소드를 해당 클래스가 구현 대신 하기.
		// !!!!! : implements 키워드 사용시 해당 추상 메소드를 구현하기 전까지 오류가 발생한다.
		System.out.println("TV를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
	
	
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			//만약에 볼륨이 최대볼륨보다 크면
			this.volume = RemoteControl.MAX_VOLUME;
			//해당 객체는 최대볼륨으로 대입 [ * 10보다 크게될수없다 ]
		}
		else if(volume<RemoteControl.MIN_VOLUME) {
			//만약에 볼륨이 최소볼륨보다 작으면
			this.volume=RemoteControl.MIN_VOLUME;
			//해당 객체는 최소볼륨으로 대입 [ * 0보다 작게될수없다 ]
		}else {this.volume=volume;}
		System.out.println("현재 Audio 볼륨:" + this.volume);
		
	}

}
