package jsp.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.Border;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Test05
 */
@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Test05() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 임의로 게시물 dto 만들기
		BoardDto boardDto = new BoardDto("제목2","안녕하세요");
		// Dto ---> JSON 변환 [ *JS에게 데이터 전달하는데....JS는 Dto타입 몰라...] 번역
				//JAVA가 문자열타입의 JSON모양 만들어서 JS에게 전달
				//라이브러리 : jackson
		// 1. Dto --> JSON 변환 해주는 변환객체 
				//ObjectMapper 클래스 : JAVA 객체를 JSON 형식으로 변환해주는 함수들을 제공하는 라이브러리
			
		ObjectMapper mapper = new ObjectMapper();
		String jsonData= mapper.writeValueAsString(boardDto);
		System.out.println("자바[String타입]에서의 JSON모양 변환해주는 라이브러리[jackson] "+jsonData);
		//2. 응답 타입
		response.setContentType("application/json;charset=UTF-8");
		//3. 응답 데이터
		response.getWriter().print(jsonData);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
