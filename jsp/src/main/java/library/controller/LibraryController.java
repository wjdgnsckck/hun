package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import library.model.dao.LibraryDao;
import library.model.dto.LibraryDto;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      ObjectMapper objectMapper = new ObjectMapper();
      String jsonArray = objectMapper.writeValueAsString( LibraryDao.getInstanct().getSitList() );   
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().print( jsonArray );
   }
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
         /*String acontent = request.getParameter("acontent"); 
         System.out.println(acontent);
         int aprice = Integer.parseInt(request.getParameter("aprice")) ;
         System.out.println(aprice);
         String adate = request.getParameter("adate");
         System.out.println(adate);
         
         //객체화
         AccountbookDto accountbookDto  = new AccountbookDto(acontent,aprice,adate);
         System.out.println(accountbookDto);
         boolean result = AccountbookDao.getInstanct().awriter(accountbookDto);
         
         response.setContentType("application/json;charset=UTF-8"); 
         response.getWriter().print(result);*/
      }
      

   /**
    * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
    */
   protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int lno = Integer.parseInt(request.getParameter("lno")); 
         String lname = request.getParameter("lname");      
         String lphonenumber   =request.getParameter("lphonenumber");   
         
         //객체화
         LibraryDto dto = new LibraryDto(lno, lname, lphonenumber);
         boolean result = LibraryDao.getInstanct().entrance(lno,lname,lphonenumber);
         //반환하기
         response.setContentType("application/json;charset=UTF-8"); 
         response.getWriter().print(result);
         
         }

   /**
    * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
    */
   protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      response.setContentType("application/json;charset=UTF-8");
	      //getphone
	      response.getWriter().print(LibraryDao.getInstanct().leave(Integer.parseInt(request.getParameter("lno")),request.getParameter("getphone")));
	   }

}