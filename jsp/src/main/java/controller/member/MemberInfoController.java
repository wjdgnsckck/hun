package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberInfoController() {
        super();
       
    }

    //2. 회원정보//로그아웃(세션 초기화)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 요청 [기능 구분을 위한 요청]
	String type = request.getParameter("type");
		//* 만약에 type 이 info이면
		if(type.equals("info")) {

			//* 세션에 객체화된 로그인 세션을 꺼낸다.
				//1. 세션호출[세션타입은 object]
			Object session = request.getSession().getAttribute("loginDto");
				//2. 타입변환한다[부=>자 강제타입변환]
			MemberDto loginDto = (MemberDto)session;
				//-DTO 는 JS가 이해할수 없는 언어이므로 JS가 이해할수 있게 JS 언어 변환 [jackson]
			ObjectMapper objectMapper = new ObjectMapper();
			String json=objectMapper.writeValueAsString(loginDto);
			
			response.setContentType("application/json;charset=UTF-8"); 
			response.getWriter().print(json);	
		}
		else if(type.equals("logout")) {
			// * 세션에 저장된 로그인객체를 없애기 / 초기화하기
			// 방법 1 : (세션의 모든 속성) 초기화하는 함수
			//request.getSession().invalidate() ; //로그인 정보 뿐만 아니라 모든게 삭제된다.
			// 방법 2 : JVM GC(쓰레기수집기)(세션의 특성 속성)
				//삭제할 세션속성명과 동일하게 null대입
			request.getSession().setAttribute("loginDto", null);
	}
	}
	//1. 요청한다 . [x]
	//2. 유효성/객체화[x]
	//3.Dao 처리[x]
	//4.응답한다.
		
		
	

	//회원삭제에서 사용 mpwd 찾기 
	//강사님은 delete에서 한번에 찾는다!!(로그인 세션에 mno와 받은 mpwd를 매개변수로 받아서 DAO 에서 한번에 처리)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. JS에서 mpwd 호출하기
	String mpwd=request.getParameter("mpwd");

	//2. Dao 에게 전송하기 (mpwd와 일치한 회원이 있는지 확인하기)
	boolean result = MemberDao.getInstanct().FindPwd(mpwd);
	
	//3.result (true(일치한 회원이 있다) , false(일치한 회원이 없다)를 js에 반환하기)
	response.setContentType("application/json;charset=UTF-8"); 
	response.getWriter().print(result);	
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//multipart/form-data 전송 요청 // cos.jar [MultipartRequest클래스]
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/Member/img"),
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy()); //중복시 자동으로 번호를 부여함
		//--------------------DB 업데이트------------//
		//*form 전솔일때는 input의 데이터 호출시 **form은 jsp 의 name식별자로 확인해야한다!
		// 일반 input : multi.getParameter("input name")
		// 첨부 input : multi.getFilesystemName("input name")
		String mimg =multi.getFilesystemName("mimg");
		String mpwd=multi.getParameter("mpwd");
		String newMpwd=multi.getParameter("newMpwd");
		
		//Dao 
		Object object = request.getSession().getAttribute("loginDto");
	
		MemberDto memberDto = (MemberDto)object;
		
		int loginMno=memberDto.getMno();
		
		if(mimg==null) {
			mimg = memberDto.getMimg();
		}
		boolean Findpwd=MemberDao.getInstanct().FindPwd(mpwd);
		
		if(Findpwd==true) {//만약 pwd가 일치하면
		boolean result =  MemberDao.getInstanct().mupdate(mimg,loginMno,newMpwd);
		System.out.println(result);
		response.setContentType("application/json;charset=UTF-8"); 
		response.getWriter().print(result);
		}
	}

	//삭제하기!
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 삭제할때 필요한 회원의 로그인 세션을 가져온다!
	Object session = request.getSession().getAttribute("loginDto");
	//2. 타입변환한다[부=>자 강제타입변환]
	MemberDto loginDto = (MemberDto)session;
	//3. DAO에서 DB처리!
	boolean result= MemberDao.getInstanct().DeletePwd(loginDto.getMid());
	//4. 만약 result가 true 이면 로그인 세션 초기화 (js에서 logout 함수를 호출하면 사용x) 
	//if(result) {request.getSession().setAttribute("loginDto", null);}
	//5. JS에 응답해준다
	response.setContentType("application/json;charset=UTF-8"); 
	response.getWriter().print(result);	
	
	}

}
