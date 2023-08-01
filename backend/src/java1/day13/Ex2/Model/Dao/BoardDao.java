package java1.day13.Ex2.Model.Dao;

import java.util.ArrayList;

import java1.day13.Ex2.Model.Dto.BoardDto;

public class BoardDao {
	
	//싱글톤 O:게시물마다 가 아닌 모든 게시물이 동일한 기능 수행
	private static BoardDao boardDao= new BoardDao();
	
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	private BoardDao() {};
	
	
			//1.배열
	//public BoardDto[] boardDtoArray= new BoardDto[100];
			//2. 리스트 : 배열을 쉽게 사용할수 있도록 다양한 함수 제공
	public ArrayList<BoardDto> boardList = new ArrayList<>();
		//ArrayList : 배열처럼 사용가능한 클래스 객체 선언
			//<클래스> : 리스트객체 안에 여러개 객체를 저장할 객체의 타입
				//boardList : 리스트객체변수명
	//-리스트 
			//-리스트객체명.add(객체명) : 해당 객체를 리스트에 저장
			//
	
		
}
