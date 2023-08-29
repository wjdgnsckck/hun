package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberController() {
        super();
     
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath="C:\\Users\\504\\git\\hun\\jsp\\src\\main\\webapp\\Member\\img"; //첨부파일 절대경로
		//첨부파일 전송 했을때.
			//1. 첨부파일 서버PC에 업로드 ( COS.Jar 라이브러리 )
					//MultipartRequest : 파일 업로드 클래스
			MultipartRequest multi =new MultipartRequest(
					request,					  //1. 요청방식 
					uploadpath,					  //2. 첨부파일을 저장할 폴더 경로
					1024*1024*10,				  //3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
					"UTF-8",					  //4.한글인코딩타입
					new DefaultFileRenamePolicy() //5.만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙여준다.
				);	
			//2. form 안에 있는 각 데이터 호출
			//일반input = multi.getParameter(form 객체전송시input name)
			//첨부파일input =  multi.getFilesystemName(첨부파일 name)
		//request.getParameter("form객체전송시 input name")
		String mid=multi.getParameter("mid") ; System.out.println(mid);
		String mpwd=multi.getParameter("mpwd");System.out.println(mpwd);	
		String memail = multi.getParameter("memail");System.out.println(memail);
		String mimg = multi.getFilesystemName("mimg");System.out.println(mimg);
		//응답받은 데이터를 객체화 하기
		MemberDto dto = new MemberDto(mid,mpwd,memail,mimg);
		//DAO에 이동하기
		boolean result = MemberDao.getInstanct().Signup(dto);
		
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
		
		
	}
    /* 첨부파일 없을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서 응답받기(request.getParameter)
		String mid=request.getParameter("mid") ; System.out.println(mid);
		String mpwd=request.getParameter("mpwd");System.out.println(mpwd);	
		String memail = request.getParameter("memail");System.out.println(memail);
		String mimg = request.getParameter("mimg");System.out.println(mimg);
		//응답받은 데이터를 객체화 하기
		MemberDto dto = new MemberDto(mid,mpwd,memail,mimg);
		//DAO에 이동하기
		boolean result = MemberDao.getInstanct().Signup(dto);
		
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
		
		
	}
	*/
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
