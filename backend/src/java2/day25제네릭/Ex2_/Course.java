package java2.day25제네릭.Ex2_;

public class Course {
	//모든 사람등록
	
	public static void registerCourse1(Applicant<?> applicant) {
		//1. 타입 확인
		System.out.println(applicant.kind.getClass().getSimpleName()+"이(가)( Course1를 등록함)");
		
		
	}
	//2. 학생만 등록 가능 [ 매개변수에 student 클래스와 자손 클래스의 타입 가능 ] Applicant < ? extends Student >
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		
		System.out.println(applicant.kind.getClass().getSimpleName()+"이(가)( Course2를 등록함)");
	}
	
	
	//3. 직장인 및 일반인만 등록 가능[ 매개변수에 Worker 클래스와 부모 클래스 타입 가능] Applicant < ? extends Worker >
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		
		System.out.println(applicant.kind.getClass().getSimpleName()+"이(가)( Course3를 등록함)");
	}

}
