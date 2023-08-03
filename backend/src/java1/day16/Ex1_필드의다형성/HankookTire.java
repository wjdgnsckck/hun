package java1.day16.Ex1_필드의다형성;

public class HankookTire extends Tire{
	// 상속 : 자식클래스  extends 부모클래스
	//1.필드
	//2.생성자
	//3.메소드
	//오버라이딩: 부모클래스의 메소드를 물려받았지만 재정의(커스텀)
	@Override
	public void roll() {
		
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다.");
	}
	

}
