package java2.day25제네릭.Ex2_;

public class Person {
	
	/*				---extends---> Worker
	 	사람클래스
	  
	  				---extends---> Student
	  				 							-----extends--->HighStudent
	  				 							-----extends--->MiddleStudent
	  
	 */

}

// * 하나의 .java 파일 안에 여러개 클래스 선언 가능
// 직장인 클래스
class Worker extends Person{}


// 학생 클래스
class Student extends Person{}

// 고등학생 클래스
class HighStudent extends Student{}

// 중학생 클래스
class MiddleStudent extends Student{}