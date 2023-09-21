package controller.list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

/**
 * Servlet implementation class PwishListController
 */
@WebServlet("/PwishListController")
public class PwishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PwishListController() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String type =request.getParameter("type");
	if(type.equals("findByWish")) {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		boolean result = ProductDao.getInstanct().getWish(mno, pno);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	else if(type.equals("findByAll")) {
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		List<ProductDto> result = ProductDao.getInstanct().getWishProductList(mno);
		
	
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		System.out.println(jsonArray);

	}
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pno = Integer.parseInt(request.getParameter("pno"));
	int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ) .getMno();
	boolean result = ProductDao.getInstanct().setWish(mno, pno);
	response.setContentType("application/json;charset=UTF-8");
	response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
