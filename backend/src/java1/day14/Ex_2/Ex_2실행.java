package java1.day14.Ex_2;

public class Ex_2실행 {
	public static void main(String[] args) {
		int r = 10;
		//1.부모객체 생성
		Calculator calculator = new Calculator();
		//2.부모객체가 부모클래스 맴버 메소드 호출
		System.out.println("원 면적 :"+calculator.areaCircle(r));
		
		// 3. 자식객체 생성
		Computer computer = new Computer();
		//4.자식 객체가 부모클래스 맴버 메소드 호출
		System.out.println("원 면적:"+computer.areaCircle(r));
	}
	
}
