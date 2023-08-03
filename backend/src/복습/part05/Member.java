package 복습.part05;

public class Member {
	//설계용
	//1.필드
	String id;
	String password;
	String name;
	String phone;
	int age;
	//2.생성자
	public Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
	//3.메소드
}
