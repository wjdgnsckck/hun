package model.dao;

import java.net.ConnectException;

import model.dto.MemberDto;

public class MemberDao  extends Dao{
	private static MemberDao memberDao = new MemberDao();
    public static MemberDao getInstanct () {return memberDao;}
    private MemberDao() {};
    
    
    //1. 회원가입
    public boolean Signup(MemberDto dto) {
    	try {
    		
    		String sql = "insert into member(mid,mpwd,memail,mimg)values(?,?,?,?);";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, dto.getMid());
    		ps.setString(2, dto.getMpwd());
    		ps.setString(3, dto.getMemail());
    		ps.setString(4, dto.getMimg());
    		int rs = ps.executeUpdate();
    		if(rs==1) {
    			return true;
    		}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    	
    	
    	return false;
    }
    
    //2. 로그인
    
    //3. 아이디찾기
    
    //4. 비밀번호 찾기
    
    //5. 내정보 호출
    
    //6. 아이디/이메일 중복검사
    	//type  : 필드명 / data : 필드에서 찾을 값
    	//1.아이디혹은 이메일 중복검사 중복검사
    	public boolean  Exist(String type,String data) {
    		try {String sql ="select * from member where "+type+" =?";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, data);
    		rs=ps.executeQuery();
    		if(rs.next()) {
    			return true;
    		}
				return false;
			} catch (Exception e) {
				System.out.println(e);
			}
    		return false;
    	}
    
    //7. 회원수정
    
    //8. 회원탈퇴
    
}
