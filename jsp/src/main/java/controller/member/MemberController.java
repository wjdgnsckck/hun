package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberController() {
        super();
     
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서 응답받기(request.getParameter)
		String mid=request.getParameter("mid") ; System.out.println(mid);
		String mpwd=request.getParameter("mpwd");System.out.println(mpwd);	
		String memail = request .getParameter("memail");System.out.println(memail);
		String mimg = request .getParameter("mimg");System.out.println(mimg);
		//응답받은 데이터를 객체화 하기
		MemberDto dto = new MemberDto(mid,mpwd,memail,mimg);
		//DAO에 이동하기
		boolean result = MemberDao.getInstanct().Signup(dto);
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
		
		
	}
	//로그인!!! 읽는거 read()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//DAO에 이동하기
		//response.setContentType("application/json;charset=UTF-8"); 
		//response.getWriter().print(result);
		
	}




	//수정!! 업데이트 이용! 회원정보 수정시 사용
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//DAO에 이동하기
				//response.setContentType("application/json;charset=UTF-8"); 
				//response.getWriter().print(result);
	}

	//삭제!! 회원정보삭제(회원탈퇴)시 사용!
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//DAO에 이동하기
				//response.setContentType("application/json;charset=UTF-8"); 
				//response.getWriter().print(result);
	}

}
