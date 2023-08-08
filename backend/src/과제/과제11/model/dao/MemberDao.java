package 과제.과제11.model.dao;

import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao memberDao =new MemberDao ();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}

		//2.회원가입SQL
	public boolean signupSQL(MemberDto dto) {
	
		System.out.println(dto);
		//1. 회원가입 필요한 SQL을 문자열에 작성해서 저장
			//테이블에 레코드 삽입 : insret into 테이블명(필드명) values(매개변수1,매개변수2,매개변수3)
				String sql = "insert into member (uid , upw , uname , uphone) values( ? , ? , ? , ? )";
				
			try {	//Connection , PreparedStatement , ResultSet 예외 처리 필수 !!(다른곳에 연동시에는 DB처리가 필수이다)
				//*주의사항!! PrepareStatement !=PreparableStatement<RES_T>
				
				//2. 위에서 작성한 	SQL을  DB연동객체에 대입 
				//3. 대입한 SQL 조작하기 위해 반환된 prepareStatement를 ps 대입
				ps=conn.prepareStatement(sql); 	//db연동객체.prepareStatement(조작할SQL문자열)
				//conn,ps 필드는 Dao 부모클래스에게 물려받음
				
				//4.SQL에서 작성한 매개변수(?)에 값 대입[.setString(?순서번호 , 값)]
			    ps.setString(1, dto.getUid());
			    ps.setString(2, dto.getUpw());
			    ps.setString(3, dto.getUname());
			    ps.setString(4, dto.getUphone());
			    
			    //5.SQL실행						[ps.executeUpdate() : SQL 실행]
			    ps.executeUpdate();
			    return true;
			}catch (Exception e) {
				System.out.println("경고] 회원가입실패 사유:"+e);
				
			}
			return false;
			 
	}   
	//회원가입 유효성검사
	public boolean  infoCheck(String 검색할필드명 , String 검색할값) {
		String sql =  "select * from member where "+ 검색할필드명 +" = ?";
		try {
		        // 2단계: SQL 조작할 수 있는 객체 필요함으로 PreparedStatement 반환받기
		        ps = conn.prepareStatement(sql);
		       
		        // 3단계: SQL 조작 [ SQL 안에 있는 매개변수[?]에 값 대입
		        ps.setString(1, 검색할값);
		       
		        // 4단계: SQL 실행해서 삭제된 행의 개수 반환 [executeUpdate()]
		        rs= ps.executeQuery();
		        
		     if(rs.next()) {return true;}
		    } catch (Exception e) {
		     System.out.println(e);
		       
		    }return false;
	}

		//3.로그인SQL
	public boolean loginSQL(String id , String pw) {
		// 1단계 : SQL 작성한다. [ 추천 :MYSQL 워크벤치에서 임의의값으로 테스트]
		String sql="select uid,upw from member where uid = ? and upw=?";
		
		try {
			//2단계 : SQL 조작할수 있는 객체 필요함으로 prepareStatement 반환받기
		ps=conn.prepareStatement(sql); 	//db연동객체.prepareStatement(조작할SQL문자열)
			//3 단계 : SQL 조작 [ SQL안에 있는 매개변수[?]에 값 대입
	     ps.setString(1,id);
		 ps.setString(2,pw);
		 	//4 단계 : SQL 실행해서 그 결과객체 를 rs객체에 대입 [ *ps는 결과를 조작할수 없다. ] 
		 		//[insert/update/delete : ps.executeUpdate(); / select :ps.executeQuery();]
		 rs=ps.executeQuery();
		 	//5단계 : SQL 실행 결과 조작 [rs.next() : 결과중에서 다음 레코드객체 호출 ]
		 		//만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1객체 ->레코드2객체 -> 레코드3객체]
		 		//								.next()			.next()			.next()		한칸씩 이동
		 if(rs.next()) {//로그인SQL 결과레코드는  1개 또는 0개 이므로 if 사용해서 .next() 1번 사용한다. 
			 			//next() 다음레코드가 존재하면 true / 아니면 false
			 return true;// 검색된 회원번호(umo)를 반환한다.
			 }//if end
		}//t end
		
		catch (Exception e) {
			System.out.println("경고] 없는 비밀번호입니다."+e);
			return false;
		} //c end
		return false;
		
		
	} //p end
		//conn,ps 필드는 Dao 부모클래스에게 물
		//1.db연동했으니 db값을 확인해야한다.
		//2.연동한 db값이랑 입력받은 값을 비교한뒤 같으면 true 다르면 false
	public String idFindSQL(String name,String phone) {
		String uid="없는 정보입니다.";
		String sql = "SELECT uid FROM member WHERE uname = ? AND uphone = ?;";
		try {
			//2단계 : SQL 조작할수 있는 객체 필요함으로 prepareStatement 반환받기
		ps=conn.prepareStatement(sql); 	//db연동객체.prepareStatement(조작할SQL문자열)
			//3 단계 : SQL 조작 [ SQL안에 있는 매개변수[?]에 값 대입
	     ps.setString(1,name);
		 ps.setString(2,phone);
		 	//4 단계 : SQL 실행해서 그 결과객체 를 rs객체에 대입 [ *ps는 결과를 조작할수 없다. ] 
		 		//[insert/update/delete : ps.executeUpdate(); / select :ps.executeQuery();]
		 rs=ps.executeQuery();
		 	//5단계 : SQL 실행 결과 조작 [rs.next() : 결과중에서 다음 레코드객체 호출 ]
		 		//만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1객체 ->레코드2객체 -> 레코드3객체]
		 		//								.next()			.next()			.next()		한칸씩 이동
		 if(rs.next()) {//로그인SQL 결과레코드는  1개 또는 0개 이므로 if 사용해서 .next() 1번 사용한다. 
			 			//next() 다음레코드가 존재하면 true / 아니면 false
			uid =rs.getString("uid");
			 }//if end
		}//t end
		
		catch (Exception e) {
			
			
		} //c end
		return uid;
		
	} //p end
	
	public String pwFindSQL(String id , String phone) {
		String upw="없는 정보입니다. ";
		String sql = "SELECT upw FROM member WHERE uid = ? AND uphone = ?;";
		try {
			//2단계 : SQL 조작할수 있는 객체 필요함으로 prepareStatement 반환받기
		ps=conn.prepareStatement(sql); 	//db연동객체.prepareStatement(조작할SQL문자열)
			//3 단계 : SQL 조작 [ SQL안에 있는 매개변수[?]에 값 대입
	     ps.setString(1,id);
		 ps.setString(2,phone);
		 	//4 단계 : SQL 실행해서 그 결과객체 를 rs객체에 대입 [ *ps는 결과를 조작할수 없다. ] 
		 		//[insert/update/delete : ps.executeUpdate(); / select :ps.executeQuery();]
		 rs=ps.executeQuery();
		 	//5단계 : SQL 실행 결과 조작 [rs.next() : 결과중에서 다음 레코드객체 호출 ]
		 		//만약에 결과의 레코드 3개 가정 [ rs = null -> 레코드1객체 ->레코드2객체 -> 레코드3객체]
		 		//								.next()			.next()			.next()		한칸씩 이동
		 if(rs.next()) {//로그인SQL 결과레코드는  1개 또는 0개 이므로 if 사용해서 .next() 1번 사용한다. 
			 			//next() 다음레코드가 존재하면 true / 아니면 false
			upw =rs.getString("upw");
			 }//if end
		}//t end
		
		catch (Exception e) {
			
			
		} //c end
		return upw;
		
	}
	//5.회원정보삭제
	public boolean deleteSQL(String id,String pw) {
		String sql = " delete from  member where uid=? and upw =?;";
		 try {
		        // 2단계: SQL 조작할 수 있는 객체 필요함으로 PreparedStatement 반환받기
		        ps = conn.prepareStatement(sql);
		        
		        // 3단계: SQL 조작 [ SQL 안에 있는 매개변수[?]에 값 대입
		        ps.setString(1, id);
		        ps.setString(2, pw);
		        
		        // 4단계: SQL 실행해서 삭제된 행의 개수 반환 [executeUpdate()]
		        int rowsAffected = ps.executeUpdate();
		        
		        ps.close(); // PreparedStatement 닫아줌
		        
		        // 삭제된 행의 개수가 1 이상이면 성공
		        return rowsAffected > 0;
		    } catch (Exception e) {
		        System.out.println("경고] 오류가 발생했습니다." + e);
		        return false;
		    }
		}
	public boolean updateSQL(String id,String pw,String pw2) {
				
				String sql="update member set upw=? where uid=? and upw=?";
				try {
				ps=conn.prepareStatement(sql); 	
			     ps.setString(1,pw2);
			     ps.setString(2, id); 
			     ps.setString(3,pw);
			     int rowsAffected = ps.executeUpdate();
			     //수정된 행의 개수가 1개 이상이면 성공
				return rowsAffected > 0 ;
				}
				catch (Exception e) {
					System.out.println("경고] 없는 비밀번호입니다."+e);
					return false;
				} //c end
				
	}
	
	}//c end

