package java2.day26_컬랙션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex3_예제 {
	public static void main(String[] args) {
		// ArrayList 객체
		List<String> list1 = new ArrayList<>();
			// ArrayList vs LinkedList
			// 사용방법 동일 	, 내부구조 설계 다르다.
			// 배열에 객체저장   , 객체를 체인처럼 연결
			//.add(객체) : 마지막 인덱스에 객체 추가
			//.add(인덱스,객체) : 해당 인덱스에 객체 추가
				// 속도 차이
				/*
				 						추가		중간삽입	중간삭제
				 	ArrayList			빠름		느림		느림			[ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ] [ 5 ] 
				 												
				 	
				 	LinkedList			느림		빠름		빠름			[ 0 ]-[ 1 ]-[ 2 ]-[ 3 ]-[ 4 ]-[ 5 ] 
				 	
				 	--- 리스트내 중간 데이터를 삽입/삭제 하는게 많으면 ArrayList 비효율적이다. [ p.642 ]
				 	--- 리스트내 중간 데이터를 삽입/삭제 하는게 많으면 LinkedList 효율적이다.
				 	[p.642 자료구조 확인해보기]
				 
				 */
		// LinkedList 객체
		List<String> list2 = new LinkedList<>();
		
		// 두 객체의 저장 속도 체크
		long startTime;		// 시작시간
		long endTime;		// 끝시간
		
		// 밀리초 (1/1000초) 나노초( 1/1000000000초 )
		startTime = System.nanoTime(); //현재시간을 나노시간으로 호출/반환받기
		for(int i = 0 ; i<10000000 ; i++) {list1.add(0,i+"");}
		endTime = System.nanoTime(); //현재시간을 나노시간으로 호출/반환받기
		
		System.out.println(" ArrayList 10000개를 저장하는데 걸리는 시간 : " + (endTime-startTime) );
		
		// 밀리초 (1/1000초) 나노초( 1/1000000000초 )
		startTime = System.nanoTime(); //현재시간을 나노시간으로 호출/반환받기
		for(int i = 0 ; i<10000000 ; i++) {list2.add(0,i+"");}
		endTime = System.nanoTime(); //현재시간을 나노시간으로 호출/반환받기
		
		System.out.println("LinkedList 10000개를 저장하는데 걸리는 시간 : " + (endTime-startTime) );
	}
}
