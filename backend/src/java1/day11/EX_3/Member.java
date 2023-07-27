package java1.day11.EX_3;

public class Member {
	//프로그램내 객체가 1개인 객체
	
	//1.자신의 타입으로 객체를 생성한다	-->private
	private static  Member member = new Member();
	
	//2.싱글톤객체를 반환하는 함수생성
	public static Member getInstance() {return member;}
	//3.외부에서 사용 못하게 생
	
	
	public Member() {};
}
