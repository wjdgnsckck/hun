package java1.day08.Ex_4;
//실행목적
public class Ex_4예제 {//class s
	public static void main(String[] args) {
		
		
		//1. Car 객체 선언 :클래스명 변수명 = new 생성자명();
		Car myCar = new Car();
		
		//2. 객체를 이용한 필드 호출 [ .접근연산자]
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println(myCar.speed);
		
		//3. 필드의 값 변경
		myCar.speed=60;
		System.out.println("수정된 속도 :"+myCar.speed);
	}
}//class e
