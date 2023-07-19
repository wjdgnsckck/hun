package java1.day05;

public class EX_2문자열 {
	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		System.out.println(name1==name2);
		
		String name3=new String("홍길동");
		String	 name4=new String("홍길동");
		
		System.out.println(name3==name4);
		
		if (name1==name2) {System.out.println("두 문자열 같습니다.");} 
		else {System.out.println("두 문자열 다릅니다.");}
		if (name3==name4) {System.out.println("두 문자열 같습니다.");} 
		else {System.out.println("두 문자열 다릅니다.");}
		
		String ssn="9506241230123";
		char sex=ssn.charAt(6);
		
		if(sex=='1' || sex =='3') System.out.println("남자입니다.");
		else  System.out.println("여자입니다.");
		System.out.println("주민등록번호 길이 :"+ssn.length());
		
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
		
		String ssn2="880815-1234567";
		
		String FirstNum=ssn2.substring(0,6);
		System.out.println(FirstNum);
		
		String secondNum =	ssn2.substring(7);
		System.out.println(secondNum);
		
		System.out.println(ssn2.split("-")[0]);
		System.out.println(ssn2.split("-")[1]);
		
		String subString = "자바 프로그래밍";
		
		int location=subString.indexOf(0);
		System.out.println(location);
		
	}
}
