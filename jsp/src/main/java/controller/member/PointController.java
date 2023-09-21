package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PointController() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		Object object = request.getSession().getAttribute("loginDto");
		MemberDto memberDto = (MemberDto)object;
		int mno = memberDto.getMno();
		if(type.equals("getPoint")) {
		
		long result = MemberDao.getInstanct().getPoint(mno);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( result );
		}
		else if (type.equals("getPointList")) {
			List<MpointDto> result = MemberDao.getInstanct().getPointlist(mno);
			ObjectMapper mapper = new ObjectMapper(); 
			String json = mapper.writeValueAsString(result);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print( json );
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpno = UUID.randomUUID().toString() ;
		
		String mpcomment= request.getParameter("mpcomment");
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto")).getMno() ;
		int mpamount = Integer.parseInt(request.getParameter("mpamount")) ;
		System.out.println("mpamount:"+mpamount);
		System.out.println("mpcomment:"+mpcomment);
		
		String mpdate=null;
		
		MpointDto dto = new MpointDto(mpno, mno, mpamount, mpcomment, mpdate);
		boolean result = MemberDao.getInstanct().setPoint(dto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( result );
	
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
