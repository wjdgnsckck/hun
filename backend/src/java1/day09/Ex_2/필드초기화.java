package java1.day09.Ex_2;



public class 필드초기화 {
		
	public static void main(String[] args) {
		
			//1. 객체 생성
					//1.기본생성자 : 객체 생성시 초기화x
		Korean k =new Korean();
				System.out.println(k.nation);	//String nation="대만민국"
				System.out.println(k.name);		//String name; --->기본값 null
					//2. 정의한 생성자 : 객체 생성시 해당 매개변수로 초기화
			Korean k1= new Korean("박자바","011225-1234567");
				System.out.println(k1.nation);
				System.out.println(k1.name);
		
					//3. 정의한 생성자2 : 
			Korean k2 = new Korean("김자바" ," 930525-0654321");
				System.out.println(k2.nation );
				System.out.println(k2.name);
				
			
				
			//2. 생성자 오버로딩
				
	}
}

//오버로딩 : 동일한 메소드명으로 여러개 선언 불가능 => 식별 불가능
	// 해결책 : 매개변수의 개수/타입/순서 이용한 메소드 식별 => ㄷ