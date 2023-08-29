package java2.day28_컬렉션프레임워크3;

public class Person implements Comparable<Person>{
	//메소드 [ 정렬 기준 만들기] **sql에서 정렬하고 오면 편하다(order by)
		//	1.Comparable 인터페이스
		//2. CompareTo메소드 구현
	@Override
	public int compareTo(Person o) {
			//오름차순
			if(age < o.age)return-1;
			else if(age==o.age) return 0;
			else return 1;
		
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	//필드
	public String name;
	public int age;
	//생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
