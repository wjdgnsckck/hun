
package java2.day25제네릭.Ex2_;

public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {
		// 모든 사람이 신청 가능
		// 1. 사람 객체
		Person person = new Person();
		// 2.
		 Applicant<Person> applicant = new Applicant<>(person);
		 Course.registerCourse1(applicant);

		// 교제
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 학생만 신청가능
		// Course.registerCourse2(new Applicant<Person>(new Person())); !! 학생
		// course2사용불가능 상속관계 x
		// Course.registerCourse2(new Applicant<Worker>(new Worker())); !! 학생
		// course2사용불가능 상속관계 x
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();

		// 직장인 및 일반인만 신청 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		// Course.registerCourse3(new Applicant<Student>(new Student())); 학생은
		// ->고등학생->중학생 상속!! 일반인 직장인 과는 상속관계x라서 사용불가능
		// Course.registerCourse3(new Applicant<HighStudent>(new HighStudent())); 학생은
		// ->고등학생->중학생 상속!! 일반인 직장인 과는 상속관계x라서 사용불가능
		// Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
		// 학생은 ->고등학생->중학생 상속!! 일반인 직장인 과는 상속관계x라서 사용불가능
		System.out.println();

	}
}
