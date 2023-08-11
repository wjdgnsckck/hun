package 과제.과제11강사님버전.controller;

import java.util.ArrayList;

import java1.day11.Ex_1.B;
import 과제.과제11강사님버전.model.dao.BoardDao;
import 과제.과제11강사님버전.model.dto.BoardDto;

public class BoardController {
	//0. 싱글톤
	private static BoardController boardController = new BoardController();
    public static BoardController getInstanct () {return boardController;}
    private BoardController() {};
	// 5 boardWrite		게시물쓰기 페이지
		public boolean boardWrite(String title , String content) {
			//2. Dto [입력받은 제목 ,입력받은 내용 , 로그인된 회원정보]
			if(title.length()==0 || title.length()>50) {return false;}
			BoardDto boardDto = new BoardDto(title,content ,MemberController.getInstance().getLoginSession());
			// 3. DAO에 전달후 결고 ㅏ받아서 받은 결과 바로 반환
			return BoardDao.getInstanct().boardWrite(boardDto);
		}
		// 10 boardPrint		모든 게시물 출력
		public ArrayList<BoardDto> boardPrint() {
			return BoardDao.getInstanct().boardPrint();
		}
		// 11 boardView		개별 게시물 출력
		public BoardDto boardView(int bno) {
			return BoardDao.getInstanct().boardView(bno);
		}
		// 12 boardUpdate	게시물 수정 [ 준비물 : bno = 수정할 게시물번호를 식별할수있는 번호 ] / mno는 유효성검사[작성자임을 확인하기위해서]
		public int boardUpdate( int bno,int mno,String title, String content) {
			//1.유효성검사
				//1. 게시물의 작성자회원번호 와 로그인된 회원의번호와 일치하지않으면
			if(mno!= MemberController.getInstance().getLoginSession()) {return 3 ;}
				//2.제목 글자 수 검사
			if(title.length()<1||title.length()>50) {return 4 ;}
			
			boolean result = BoardDao.getInstanct().boardUpdate(new BoardDto(bno, title, content));
			System.out.println(result);
			if(result) return 1;
			else return 2;
		}
		// 13 boardDelete	게시물 삭제
		public int boardDelete(int bno, int mno) {
			//1. 유효성검사
			if(mno!=MemberController.getInstance().getLoginSession()) {return 3;}
			boolean result = BoardDao.getInstanct().boardDelete(bno);
			if(result)return 1;
			else return 2;
		}

}
