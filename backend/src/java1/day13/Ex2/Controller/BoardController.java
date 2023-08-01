package java1.day13.Ex2.Controller;


import java1.day13.Ex2.Model.Dao.BoardDao;
import java1.day13.Ex2.Model.Dto.BoardDto;

public class BoardController {
	//싱글톤 O:게시물마다 가 아닌 모든 게시물이 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	
	public static BoardController getInstance() {return boardController;}
	
	private BoardController() {}
	
	//-----------------------------------------------//
	
	
	//글등록 처리 기능 함수
	public boolean writeLogic(String writer , String content) {
		System.out.println("쓰기");
		
		//1. 매개변수로 부터 전달받은 content , writer 를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(writer,content);
		
		//2. 객체를 배열에 저장[ 빈공간을 찾아서 빈공간 저장]
		
		//2. 객체를 리스트에 저장
		BoardDao.getInstance().boardList.add(boardDto);
		//글 등록!! 성공[ture] 또는 실패[false]
		return true;
		
	}
	//글출력 처리 기능 함수
	public BoardDto printLogic(int index) {
		
		//1. 리스트 안에 있는 객체 호출 . get(인덱스) : 해당 인덱스의 객체 호출
		BoardDto boardDto=BoardDao.getInstance().boardList.get(index);
		//2. 클릭시마다 view를 하나씩 더하는 코드 작성하기
		//  int a = BoardDao.getInstance().boardDtoList.get(index).getView()+1;
     
      
		BoardDao.getInstance().boardList.get(index).setView(
            BoardDao.getInstance().boardList.get(index).getView()+1 );
		//2. 호출된 dto를 리턴하기
		return boardDto;
	}
	
	//글수정 처리 기능 함수
	public boolean updateLogic(int index, String writer , String content) {
		System.out.println("수정");
		//1번 객체를 이용한 저장
		BoardDto boardDto = new BoardDto(writer,content);
		BoardDao.getInstance().boardList.set(index,boardDto);
		//2번 강사님이 이용한 하나씩 값을 저장
		BoardDao.getInstance().boardList.get(index).setContent(content);
		BoardDao.getInstance().boardList.get(index).setWriter(writer);
		return true;
	}
	
	//글삭제 처리 기능 함수
	public boolean deleteLogic(int index) {
		//1. 리스트 안에 있는 객체 삭제 .get(인덱스) : 해당 인덱스의 객체호출
		BoardDao.getInstance().boardList.remove(index);
		//2. 삭제여부
		return true;
		}
}