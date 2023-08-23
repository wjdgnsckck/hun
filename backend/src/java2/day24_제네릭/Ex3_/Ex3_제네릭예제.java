package java2.day24_제네릭.Ex3_;

public class Ex3_제네릭예제 {
	public static void main(String[] args) {
		// 1. 홈 렌탈 조작하는 구현객체
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
			//2. 자동차 렌탈 구현체
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
		
	}

		
}
