package java2.day26_컬랙션프레임워크.Ex1;

import java.util.ArrayList;
import java.util.List;

public class Ex1_예제1 {

	public static void main(String[] args) {
		
	
	//1. ArrayList 컬렉션 객체 생성
	List<Board> list = new ArrayList<Board>();
			//위아래 둘다 똑같음
	//ArrayList<Board> list2 = new ArrayList<Board>();
	System.out.println("-------1 : "+list);
	
	
	//2. ArrayList 객체 안에 객체 추가
			//리스트객체명.add(객체)		:해당 객체를 리스트에 끝에 추가
			//리스트객체명.add(인덱스,객체) :해당 객체를 리스트내 인덱스 위치에 추가
			//리스트객체명.set(인덱스,객체) :해당 객체를 리스트내 인덱스 위치 바꿈
	list.add(new Board("제목","내용","글쓴이1"));
	list.add(new Board("제목","내용","글쓴이2"));
	list.add(new Board("제목","내용","글쓴이3"));
	list.add(new Board("제목","내용","글쓴이4"));
	list.add(new Board("제목","내용","글쓴이5"));
	list.add(0,new Board("제목","내용","글쓴이6"));
	list.set(2,new Board("제목","내용","글쓴이7"));	//재고 수정할때 사용하면 편할거같다
	
	Board board = new Board("제목8", "내용8", "글쓴이8"); list.add(board);	//객체생성후  list객체에 추가
	Board board2 = new Board("제목9", "내용9", "글쓴이9");					//객체생성후  list객체에 추가x
	System.out.println("-------2 : "+list);
	
	//3. ArrayList 컬렉션 안에 총 개수
	// 리스트객체명.size()		:리스트내 저장된 객체 수
	System.out.println("--------3:"+list.size()+"개");		//배열은 배열명.length
	
	//4. ArrayList 컬렉션 안에 특정 객체 검색
			//리스트객체명.get( 인덱스 )			: 리스트내 해당 인덱스 위치에 객체 반환
			//리스트객체명.contains( 객체 )		: 리스트내 해당 객체가 있으면 true / 없으면 false
			//리스트객체명.isEmpty() 			: 리스트내 객체가 모두 비어있는지 true / 아니면 false
	System.out.println("--------4 get():"+list.get(2));			//배열명[인덱스]
	System.out.println("--------4 contains():"+list.contains(board));		
	System.out.println("--------4 contains():"+list.contains(board2));
	System.out.println("--------4 isEmpty():"+list.isEmpty());
	
	
	//5. ArrayList 컬렉션 안에 특정 객체 삭제
		//리스트객체명.remove(인덱스)  : 리스트내 해당 인덱스 위치에 객체 삭제/ 1칸씩 댕겨짐
		//리스트객체명.remove(객체)	 : 리스트내 해당 객체가 존재하면 삭제
		//리스트객체명.clear() 		 : 리스트내 모든 객체 삭제 / 초기화
	list.remove(2);	//remove(인덱스) 리스트 객체내 2번 인덱스 객체 삭제
	list.remove(board); //리스트객체내 해당 객체가 존재하면 삭제
	System.out.println("--------4 remove():"+list);		//배열은 배열명.length
	list.clear();
	System.out.println("--------4 clear():"+list);		//배열은 배열명.length
	}
}
