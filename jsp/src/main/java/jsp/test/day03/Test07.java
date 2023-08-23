package jsp.test.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test07")
public class Test07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test07() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 요청
	String name = request.getParameter("name");
	int age =Integer.parseInt(request.getParameter("age"));
	//Integer.parseInt () : 문자열 타입 -> 정수형 타입
	//request.getParameter(); : 무조건 값은 문자열
		System.out.printf("[JS] AJAX가 보내온 데이터: %s %d \n" ,name,age );
			//2.Dao 처리 / 비지니스로직
		
		
	//3. 응답하기
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
