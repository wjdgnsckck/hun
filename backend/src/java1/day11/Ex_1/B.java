package java1.day11.Ex_1;

public class B {
	A a=new A();//A와B는 같은 패키지니까.
	
	public void B() {	//B클래스 생성자
		//오류 :C클래스는 호출 가능하지만 생성자는 호출불가능
		//C c = new C();
		
	}
}
