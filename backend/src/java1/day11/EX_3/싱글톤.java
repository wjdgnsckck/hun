package java1.day11.EX_3;

public class 싱글톤 {
	public static void main(String[] args) {
		
		//1.맴버 객체생성
			//오류 : 생성자를 private 되어 있는 클래스는 외부에서 객체생성 불가능
		//[두 객체는 다르다. ]
		//Member member1 =new Member();!=member2
		//Member member2 =new Member();
		
		//2. Member 객체 호출 [ 두 객체는 같다. ]
		Member member3=Member.getInstance();
		Member member4=Member.getInstance();
		System.out.println(member3==member4);
	}

}
