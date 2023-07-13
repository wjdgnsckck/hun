package java1.day01;

public class EX1_변수 {
	
	//main + 컨트롤 +스페이스바 =>엔터 자동완성
	public static void main(String[] args) {
		
		int hour = 3;
		
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute = (hour*60)+ minute;
		System.out.println("총 "+ totalMinute + "분");
		/*
		 변수 : 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름
		 
		 형태:
		 	타입 변수명 ; 				//선언
		 	타입 변수명 = 초기값; 	//선언과 동시에 처음값 저장
		 	
		 타입: 미리 정해진 변수의 크기
		 변수명 : 메모리 번지 대신에 식별용으로 사용되는 메모리 이름[카멜 표기법]
		 = : 오른쪽에 데이터를 왼쪽에 대입
		 초기값 : 변수 선언시 저장할 데이터
		 
		 
		  */
	}

}
