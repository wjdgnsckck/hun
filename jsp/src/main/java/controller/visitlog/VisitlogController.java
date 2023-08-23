package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;


@WebServlet("/VisitlogController")//해당 서블릿(자바)/컨트롤러 클래스를 호출하는 HTTP 매핑주소
public class VisitlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public VisitlogController() {
        super();
      
    }
    //1.저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. AJAX의 DATA속성에 있는 객체 정보(속성명 이용)를 호출하기
		//request.getParameter("객체의속성명");
		
		String vwirter = request.getParameter("vwirter"); 
		System.out.println(vwirter);
		String vpwd = request.getParameter("vpwd"); 
		System.out.println(vpwd);
		String vcontent = request.getParameter("vcontent");
		System.out.println(vcontent);
		
		
		//2. 객체화
		
		VisitDto visitDto = new VisitDto(vwirter,vpwd,vcontent);
		System.out.println(visitDto);
		
		// 3. DAO 객체 전달후 결과 응답 받고
		boolean result =VisitDao.getInstanct().vwriter(visitDto);
		
		//4. 결과를 AJAX에게 응답한다.
		//response.getWriter().print("응답할데이터");
		//response.setContentType("text/html"); // (생략시 기본값) js에서 "true"
		response.setContentType("application/json;charset=UTF-8"); // js에서 "true"
		response.getWriter().print(result);
		
	}
	//2.호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청	[X] : 모든 글 출력은 조건이 없으므로 요청값 없다. vs 개별 글 출력 : 조건이 출력할 글 번호
		//2. 객체화[X]  
		//3. DAO
		ArrayList<VisitDto> result =VisitDao.getInstanct().vread();
				//* JS는 ArrayList타입을 사용할수 없으므로 ArrayList타입 JSON배열로 변환해서 전달하자. [ 라이브러리 :JACKSON ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray= objectMapper.writeValueAsString(result);                		//JSON타입으로 변환은 불가능하지만 JSON 형식의 문자열로 반환
		//4. 응답
		
		//response.getWriter().print(result); // 응답은 가능하나 .. js가 ArrayList 타입 사용이 불가능하다[ 문제발생 ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
		
	}


	//3.수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	//4.삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
