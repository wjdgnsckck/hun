package java2.day24_제네릭.Ex2_;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		
		//1. Product 객체 만드는데.. tv객체를 가지는 Product 객체
			//1. product객체 만들때.. 필드에 사용할 타입 구체적으로 대입
		Product<Tv, String> product1=new Product<>();
			//2. product객체[ Tv kind = null ; String model = null ; ] * 필드의 초기값 = 정수 0 실수 0.0 boolean =false 클래스=null
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
			//3.product객체 [ Tv kind = new Tv(); String model = "스마트Tv";]
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		//2. Product 객체 만드는데.. Car객체를 가지는 Product 객체
				//1. product객체 만들때.. 필드에 사용할 타입 구체적으로 대입
		Product<Car, String> product2=new Product<>();
		//2. product객체[ Tv kind = null ; String model = null ; ] * 필드의 초기값 = 정수 0 실수 0.0 boolean =false 클래스=null
		product2.setKind(new Car());
		product2.setModel("SUV 자동차");
			//3.product객체 [ Tv kind = new Tv(); String model = "스마트Tv";]
		Car car = product2.getKind();
		String CarModel = product2.getModel();
			
	}
}
