package java2.day28_컬렉션프레임워크3.Ex3_HashTable;

import java.util.Hashtable;
import java.util.Map;

public class Ex3_예제 {
	
	 public static void main(String[] args) {
		
		 //1. HashTable 객체에 String , Integer 2개 객체를 저장하는 map객체 선언
		 Map<String , Integer> map = new Hashtable<>(); //2000개 안전하게 저장 [ 동기 = 여러 스레가 동시에 한 메소드에게 요청할때 대기상태 ]
		 //Map<String , Integer> map = new HashMap<>(); //2000개 저장이 안되거나 오류 발생 [ 비동기 ]
		 //2. // ----- 멀티스레드를 이용한 각 1000개씩 2000개를 동시 저장
		 
		 		//1. 스레드 1 선언
		 Thread threadA = new Thread() {
			 public void run() {
				 for (int i = 1 ; i<=1000 ; i++) {
					 map.put(String.valueOf(i),i);
				 }
			 };};
		 
			 
			 
			 	//2. 스레드 2 선언	
			 Thread threadB = new Thread() {
			 public void run() {
				 for (int i = 1001 ; i<=2000 ; i++) {
					 map.put(String.valueOf(i),i);
				 }
			 };};
		 
			 //개발자는 선택지가 많음.. 특징에 맞춰서 그거에 맞게 사용해야한다!(개발자의 경험에 의존해야함 제일어려움)
			 
			 threadA.start();// 두 스레드 실행
			 threadB.start();
			 
			 //main스레드는 다른 두 스레드가 작업(저장) 이 끝날때 까지 main스레드 잠시 대기
			 try{threadA.join(); threadB.join();}catch (Exception e) {} // join시 try catch 필수!!
			 
			 System.out.println("map 객체수 :"+map.size());
			 System.out.println("map 상태 :"+map); // 두 스레드 가 저장을 하기 전에 main스레드가 먼저 출력함!  
	}

}
