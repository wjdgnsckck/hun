package java1.day10.Ex_2;

public class Computer {

	//1.필드
	//2.생성자
	//3.메소드
			//1.가변(정해져있지 않는)길이 매개변수를 갖는 메소드 선언
			//2.가변길이의 일반매개변수 있을경우 가변길이 매개변수 가장 뒤에 선언
			//int sum(String str, int...values);
	int sum(int...values) {	//...키워드 이용한
				//타입...배열변수명
		
		int sum=0;	//매개변수로 들어온 여러개의 변수를 더한 변수
		
		for(int i = 0 ; i<values.length; i++) {
			sum+=values[i];
		}	//for end
		return sum;		//누적합계 반환
	}
		
}
