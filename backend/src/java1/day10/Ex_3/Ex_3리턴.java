package java1.day10.Ex_3;

public class Ex_3리턴 {

	
		public static void main(String[] args) {
			
			//1. 자동차 객체 생성
			Car myCar=new Car();
			//2. 메소드 이용한 필드에 값 대입
			myCar.setGas(5);
			//3.메소드 호출
			if(myCar.isLeftGas()) {
				//만약에 '가스여부확인' 함수가 true 반환해주면 가스가 있다는 뜻
				System.out.println("출발합니다.");
				//4.메소드 호출
				myCar.run();
			}	//if end
			System.out.println("gas를 주입하세요.");
			
			
		}
}
