package java1.day10.Ex_4;

public class Ex_4메소드 {

	public static void main(String[] args) {
		
		//--------------- 메소드 사용/호출--------------------
		//1. 객체 필요!!!
		Member m= new Member();
		//2. 객채내.(도트연산자) 이용한 필드/메소드 호출
				//1. 리턴x매개변수x 함수 호출
		m.signUp();
				//2.리턴X매개변수X함수 호출
		//	m.login("qwe","1234"); //오류 : 문자1개 정수1개 순서로 전달하는걸로 약속/선언 문자2개주니까 오류/거부
		m.login("qwe",1234);
				//3. 리턴o매개변수x 함수 호출
		m.findId();	//리턴된 값을 받았지만 추후에[다음코드] 그 값을 사용할 목적이 없어서 저장x
		//int result1=m.findId();	//리턴된 값을 받았지만 타입이 일치하지않는다.
		String result1=m.findId();	//리턴된 값을 받았지만 타입이 일치하지않는다.
		String result=m.findId();	//리턴된 값을 받아서 추후에[다음코드]에 그 값을 사용할 목적이 있어서 변수에 저장
				//4. 리턴O매개변수O 함수 호출
		String [] reuslt3=m.findPw("qwe", "Qwe");
				//5.가변길이 매개변수
		m.delete("안녕","하세요");
		m.delete("안녕","하세요","!");
		
				//6.오버로딩
		m.delete(1,"안녕","하세요","!");
	}
}
