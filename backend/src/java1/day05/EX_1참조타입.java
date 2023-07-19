package java1.day05;

public class EX_1참조타입 {
	public static void main(String[] args) {
		
	
	int[] arr1; //int형 타입으로 배열 변수 선언	[스택영역에 메모리 할당]
	int[] arr2; //int형 타입으로 배열 변수 선언
	int[] arr3; //int형 타입으로 배열 변수 선언
	
	arr1=new int[] {1,2,3};//배열 {1,2,3}을 생성[힙영역에 메모리할당]하고 [할당된주소를]스택영역변수에 대입
	arr2=new int[] {1,2,3};
	arr3=arr2;
	
	System.out.println(arr1==arr2);
	System.out.println(arr2==arr3);
	
	int[] intArray=null;
	
	String str=null;
	System.out.println(str);
	
	String hobby="여행";
	
	hobby=null;
}
}
