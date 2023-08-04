package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//무조건 java.sql에서 가져와야 한다!!!(중복 함수가 있을수 있음)


public class Dao { // 각종 Dao에 클래스를 대표하는 부모클래스
		
		//1.필드
		public Connection conn ;     //DB연동 객체 [연동만 할수있음!!]
		public PreparedStatement ps; //연동된 DB에서 SQL조작(매개변수타입,SQL실행)하는 객체
		public ResultSet rs;         //SQL 조작 결과를 가져오는 객체 ( selete)
		//2.생성자 : 객체 생성시 초기화 담당
			//기본생성자에 DB연동 코드 작성 *DAO객체생성시 바로 DB연동
		public Dao() {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web","root","1234");
			System.out.println("안내] DB연동성공");
			}catch (Exception e) {
				System.out.println("경고]연동실패"+e);
			}
		}
		

}
