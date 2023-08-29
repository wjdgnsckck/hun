package service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	//1. 필드
	private String fromEamil = ""; //보내는 사람의 이메일 [ 관리자 이메일 ]
	private String fromEmailPw="" ; //git x
	
	//2. 생성자
	public EmailService() {}
	//3. 메소드
		//1. 이메일 보내기 함수
	public boolean authsend(String toEmail,String contentHTML) {
		
		// 1. 호스팅 설정 [ 네이버 기준 ]
		Properties properties = new Properties();	//Properties : 키와 값으로 구성된 map 컬렉션 중하나. [설정 관련된 데이터 객체화]
		
		properties.put("mail.smtp.host", "smtp.naver.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		
		// 2. 인증처리 [네이버에 보내는사람의 정보가 맞는지 ] 
		
			//인증할 객체
		Authenticator authenticator = new Authenticator() {
		
			//패스워드 검증 함수 [ 구현 ]
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(fromEamil, fromEmailPw);
			}
		};
		
			//Authenticator : import javax.mail.Authenticator
			//getPasswordAuthentication() : 패스워드 검증[인증] 메소드 구현
		Session session = Session.getDefaultInstance(properties,authenticator );
					// Session : import javax.mail.Session;
					// .getDefaultInstance( 호스트설정properties, 인증할 계정정보 )
		
		//3. 메일 전송
		try {
			//Mime 프로토콜 : smtp가 보낼수 있는 표준형식/포멧/틀
			//message 객체 생성
		MimeMessage message = new MimeMessage(session);
			//2. set from(new InterfaceAddress ("보내는사람의 이메일주소"))
		message.setFrom(new InternetAddress(fromEamil));
			//3. addRecipient
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			//4. set setSubject("메일제목")
		message.setSubject("Ezen JSP회원가입 인증코드 발송");
			//5. setText("메일내용")
		message.setText(contentHTML);
			//6. Transport.send(mime객체)
		Transport.send(message);
			//--------
			return true;	//메일 전송 성공
		}catch (Exception e) {System.out.println(e);}
		return false;	//메일 전송 실패
	}
}
