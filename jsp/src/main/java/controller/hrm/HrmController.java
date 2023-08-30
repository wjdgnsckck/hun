package controller.hrm;

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

import model.dao.HrmDao;
import model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HrmController() {
        super();
     
    }

    //입력값 저장하기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uploadpath=request.getSession().getServletContext().getRealPath("/hrm/img");
    	System.out.println(uploadpath);
    	
    	MultipartRequest multi = new MultipartRequest(request, // 1. 요청방식
				uploadpath, // 2. 첨부파일을 저장할 폴더 경로
				1024 * 1024 * 10, // 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
				"UTF-8", // 4.한글인코딩타입
				new DefaultFileRenamePolicy() // 5.만약에 서버내 첨부파일이 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙여준다.
		);
    	
    	//클래스가 아닌 name 태그를 더 지정해줘야한다!!! 아니면 null값이 입력된다
    	String himg=multi.getFilesystemName("himg");System.out.println(himg);
    	String hname= multi.getParameter("hname"); System.out.println(hname);
    	String hpwd= multi.getParameter("hpwd"); System.out.println(hpwd);
    	String hrank= multi.getParameter("hrank"); System.out.println(hrank);
    	
    	if(himg==null) himg="default.webp";
    	//객체화 하기
    	HrmDto dto = new HrmDto(himg,hname,hpwd,hrank);
    	//Dao 전송하기
        boolean result=  HrmDao.getInstanct().signup(dto);
        
        
        response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
    }
	
    //인사관리 출력하기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<HrmDto> result = HrmDao.getInstanct().hread();
		System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray= objectMapper.writeValueAsString(result); 
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	

	//인사관리 수정하기
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//인사관리 삭제하기
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
