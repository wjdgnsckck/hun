package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;


@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardInfoController() {
        super();
       
    }
    //1.전체조회 2.개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	
	}

	//4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
