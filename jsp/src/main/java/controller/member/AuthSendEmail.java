package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmailService;

@WebServlet("/AuthSendEmail")
public class AuthSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthSendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 요청하기
		String memail =request.getParameter("memail");System.out.println("memail : " + memail);
		
		//2.인증번호 생성 [난수 6자리 ]
		String auth="";	//인증번호를 저장할 문자열
		for(int i = 0 ; i<6 ; i++) {
			Random random = new Random();
			random.nextInt() ; // random.nextInt() : Int 타입 범위 내 난수 생성
			auth+=random.nextInt(10); //0~9 까지의 난수 생성
			
		}; System.out.println("생성된 난수 6자리 : "+auth);
		
		
		//3. 인증번호를 해당 이메일에게 전송 [ SMTP : 간이 우편 전송 프로토콜 ]
			//메일전송서비스 객체 선언
		EmailService emailService = new EmailService();
			//객체를 통한 메일전송 함수 호출 (받는사람이메일 , 인증코드);
		emailService.authsend(memail, auth);
		
		
		//4. 인증번호 변환
		response.getWriter().print(auth);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}


/*
 
 		- 자바에서 이메일 전송 보내기
 			1. 이메일을 전송할 도메인 필요 [ 네이버 , 다음 , 구글 등등 ]
 				[ 강의 : 네이버 ( git : 패스워드 감추거나 private 저장소 ) , 2차 비밀번호는 불가능]
 				-네이버 로그인
 					-1.메일
 					-2.환경설정 -> 메뉴 -> POP3/IMAP 설정
 						[IMAP/SMTP사용]
 							-IMAP/SMTP사용 : 사용함
 						[스마트폰 메일 애플리케이션 계정 설정 ] 확인
 						SMTP 서버명 : smtp.naver.com
 						SMTP 포트 : 587, 보안 연결(TLS) 필요
			2. SMTP 라이브러리 [ 이메일 전송에 관련된 클래스/라이브러리 제공 ]
 
 */
