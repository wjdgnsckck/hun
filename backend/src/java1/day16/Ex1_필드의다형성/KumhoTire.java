package java1.day16.Ex1_필드의다형성;

public class KumhoTire extends Tire{
		//상속받으면 자식클래스에서 부모클래스의 맴버(필드,생성자,메소드)를 사용할수있다.
		@Override
		public void roll() {
			// TODO Auto-generated method stub
			System.out.println("금호 타이어가 회전합니다. ");
		}
}
