package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.Dao;
import model.dto.BoardDto;
import model.dto.MemberDto;
import model.dto.PageDto;


@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardInfoController() {
        super();
       
    }
    //type :  1.전체조회 2.개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 x
		String type = request.getParameter("type");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		if(type.equals("1")) { //전체 조회 로직
			//-------------------------1.카테고리-------------------------//
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			//--------------------------2.출력할 게시물수/하나의 페이지의 최대 게시물수----//
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			//-------------------------3 페이징 처리 하기------------------------//
			int page = Integer.parseInt(request.getParameter("page"));
				//1. 페이지별 레코드의 시작번호
			int startrow = (page-1)*listsize; //페이지번호*최대게시물수
			
				//----------4. 마지막 페이지 번호 -------------//
						//1. 마지막페이지번호/총페이지수 = 전체게시물수 / 페이지별 최대게시물수
						//2. 전체게시물수
			int totalsize = BoardDao.getInstanct().getTotalSize(bcno);
						//3. 마지막페이지번호/총페이지수
			int totalpage = totalsize%listsize== 0 ? totalsize/listsize :totalsize/listsize+1;
						// 게시물수 : 10 , 페이지별 2개씩 출력 => 총페이지수 : 5 
			ArrayList<BoardDto> result = BoardDao.getInstanct().getList(bcno,listsize,startrow);
			//------------------------------6.page 구성------------------//
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize
					, totalpage, result);
			json = objectMapper.writeValueAsString(pageDto);
			//4. 반환타입 
		
			
		}
		else if (type.equals("2")) { // 개별 조회 로직
			//1.매개변수 요청
			int bno = Integer.parseInt(request.getParameter("bno"));
		
			//2.Dao 처리
			BoardDto result=BoardDao.getInstanct().getBoard(bno) ;
			
				//3. 만약에 (로그인 혹은 비로그인)요청한사람과 게시물 작성한사람이 동일하면
			Object object = request.getSession().getAttribute("loginDto");
			
			if(object==null) {//비로그인
			 result.setIshost(false);	 //남이 쓴 글
			}
			
			else {
				MemberDto login = (MemberDto)object;
				//내가 쓴글
				if(login.getMno()==result.getMno()) {result.setIshost(true);}
				else {result.setIshost(false);}
			}
			//3. 응답
			json = objectMapper.writeValueAsString(result);
			
		}
			
	
		
		 
		//공통 로직
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(json);
		
		//3. Dao
		
	}

	//2. 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//0.첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
		
				request.getServletContext().getRealPath("/board/update"),
				1024*1024*1024,	//업로드 허용 용량 1GB
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		//1.(입력받은 매개변수) 요청
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		String bfile=multi.getFilesystemName("bfile");
		int bcno=Integer.parseInt(multi.getParameter("bcno")); 
		int mno =( (MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		//2.유효성검사/객체화
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, bcno);
		
		//3.Dao  처리
		boolean result =BoardDao.getInstanct().bwrite(dto);
		
		//4. 응답하기
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
	}

	//3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.수정할 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/board/update"),
				1024*1024*1024,	//업로드 허용 용량 1GB
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		//2.수정할 데이터 요청
		int bcno=Integer.parseInt(multi.getParameter("bcno")); System.out.println(bcno);
		String btitle=multi.getParameter("btitle");	System.out.println(btitle);
		String bcontent=multi.getParameter("bcontent");	System.out.println(bcontent);
		String bfile =multi.getFilesystemName("bfile");	System.out.println(bfile);
		
		//2* 수정할 게시물 식별키
		int bno =Integer.parseInt(multi.getParameter("bno"));
		
		//3. dto 보내기
		BoardDto dto =new BoardDto(bno, btitle, bcontent, bfile, bcno);
		if(dto.getBfile()==null) {
			dto.setBfile(BoardDao.getInstanct().getBoard(bno).getBfile());
		}
		//3.Dao에 전송하기
		boolean result = BoardDao.getInstanct().bupdate(dto);
		//전송하기
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);		
	}

	//4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//Dao
		Boolean result=BoardDao.getInstanct().bdelete(bno);
		
		
		//전송
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
	}

}
