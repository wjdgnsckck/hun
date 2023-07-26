package java1.day10.Ex_2;

public class Ex_2가변길이매개변수 {
	public static void main(String[] args) {
		//1.다른 클래스에 있는 메소드를 호출
		Computer myCom= new Computer();
		
		//2. 3개 인수로 전달
	
		System.out.println(myCom.sum(1,2,3));
		
		// 5개 인수로 전달
		System.out.println(myCom.sum(1,2,3,4,5));
		
		//4. 배열 전달
		int[] values= {1,2,3,4,5};
		System.out.println(myCom.sum(values));
		
		//5.배열2전달
		System.out.println(myCom.sum(new int[] {1,2,3,4,5}));
	}
}
