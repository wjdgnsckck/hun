package jsp.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test04
 */
@WebServlet("/Test04")
public class Test04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Test04() {
        super();
     
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. JSON타입 모양의 문자열 [ -자바는 JSON 타입없음]
		String jsonDate="{\"title\":\"제목1\" , \"content\" : \"안녕하세요\" }";
		
			// 문자열 처리 연산자
			//" " 문자처리 안에 "문자인식 => \" // " 출력하고 싶은데 => \"
		
		System.out.println("자바[String타입]에서의 JSON모양 만들기 "+jsonDate);
		//1. JSON타입
		response.setContentType("application/json;charset=UTF-8");
		//response.setContentType("text/html;charset=UTF-8"); // 문자열 타입!! 객체처럼 . 못찍음
		// 2. 전송/응답 할 데이터
		
		response.getWriter().print(jsonDate);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
