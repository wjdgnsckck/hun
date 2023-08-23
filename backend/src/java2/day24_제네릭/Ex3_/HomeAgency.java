package java2.day24_제네릭.Ex3_;

public class HomeAgency implements Rentable<Home> {
		//implements : 인터페이스(추상메소드) 구현(정의)하다.
	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();
	}
}
