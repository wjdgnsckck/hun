package java1.day16.Ex2_매개변수의다형성;

public class Taxi extends Vehicle{//자식 클래스
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다."+"(요즘택시너무비싸)");
	}

}
