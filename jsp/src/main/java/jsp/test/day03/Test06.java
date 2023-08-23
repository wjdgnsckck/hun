package jsp.test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서버내 동일한 HTTP 주소는
@WebServlet("/Test06")	//해당 클래스를 호출하는 URL 매핑(연결) HTTP 주소
public class Test06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test06() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 request
		String value1= request.getParameter("value1");	//ajax data 속성의 객체내  value1 속성의 값 요청
		//request.getParameter(data객체내 속성명);	
		System.out.println("[JS]AJAX가 보내온 데이터 : "+value1);
		//2. 응답 response
		response.getWriter().print("true");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
