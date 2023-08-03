package java1.day16.Ex2_매개변수의다형성;

public class Ex2_실행 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		//1. 부모객체
		Vehicle vehicle= new Vehicle();
		System.out.println("------------->1.차량대입");
			driver.drive(3, vehicle);
		
			//2. 자식객체
		Bus bus = new Bus();
		System.out.println("------------->2.버스대입");
	 	driver.drive(5, bus);
	 
			//2. 자식객체
		//	driver.drive("안녕하세요", taxi); 타입이 달라서 오류!
		Taxi taxi = new Taxi();
		System.out.println("------------->3.택시대입");
		driver.drive(3, taxi);
		
	}
}
