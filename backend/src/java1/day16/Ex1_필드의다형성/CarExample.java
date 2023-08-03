package java1.day16.Ex1_필드의다형성;

public class CarExample {
	//실행목적
	public static void main(String[] args) {
		// 1. Car 객체 생성

		 
	
		Car myCar = new Car(); //tire필드에 객체가 없는 상태
		System.out.println(myCar.tire);//필드에 초기화가 없으면 기본값[참조타입=null]
		//2.Tire 객체 장착
		myCar.tire=new Tire();
		myCar.run();
		System.out.println(myCar.tire);
		//3.HankookTire 객체 장착
		myCar.tire=new HankookTire();
		myCar.run();
		System.out.println(myCar.tire);
		//4.KumhoTire 객체 장착
		myCar.tire=new KumhoTire();
		myCar.run();
		System.out.println(myCar.tire);
	
	}
	
}
