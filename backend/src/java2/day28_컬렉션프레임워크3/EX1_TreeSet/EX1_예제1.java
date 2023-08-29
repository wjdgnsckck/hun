package java2.day28_컬렉션프레임워크3.EX1_TreeSet;

import java.util.TreeSet;

/*
 
 	검색 기능을 강화시킨 컬렉션
 		- 컬렉션 안에 있는 데이터를 검색할때 효율성 제공 [ 필수X ]
 		
 		-이진트리
 			- 각 노드는 최대 2개의 노드를 연결
 			- 부모 노드 보다 작으면 왼쪽 / 크면 오른쪽
 			
 			- 6 8 10 이진트리 표현	
 				 부모노드(8)
 				/		\
 			자식노드(6) 	자식노드(10)
 */

public class EX1_예제1 {
	public static void main(String[] args) {
		//1.TreeSet 컬렉션 생성
		TreeSet<Integer> scores = new TreeSet<>();
		
		//2.Integer 객체 저장
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);		// 일반적으로는 저장된 순서대로 저장 87 98 75 95 80
		System.out.println(" 이진트리 상태 : "+scores);	// 75 80 87 95 98 정렬이 자동으로 된다.
		
		// 3. 
		System.out.println(" 가장 왼쪽 노드 : "+scores.first());
		System.out.println(" 가장 오른쪽 노드 : "+scores.last());
		System.out.println(" 95점 아래 노드 : "+scores.lower(95));
		System.out.println(" 95점 위의 노드 : "+scores.higher(95));
		System.out.println(" 95점이거나 아래 노드 : "+scores.floor(95));
		System.out.println(" 95점이거나 위 노드 : "+scores.ceiling(95));
		
		//4. 내림차순
		System.out.println("이진트리 내림차순 :" +scores.descendingSet());
		
		//5. 범위검색
		//tailSet(숫자,옵션[true(이상),false(초과))
		System.out.println("이진트리 80 이상 :" + scores.tailSet(80,true)); 
		//subSet(시작숫자,옵션,끝숫자,옵션)
		System.out.println("이진트리 80 이상 90미만 :" + scores.subSet(80,true , 90 ,false));
		
		
		
		
	}

}
