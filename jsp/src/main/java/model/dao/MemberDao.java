package model.dao;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.MemberDto;
import model.dto.MpointDto;

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
    public boolean login(String mid , String mpwd) {
    	try {String sql="select*from member where mid=?and mpwd=?;";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, mid);
    	ps.setString(2, mpwd);
    		rs=ps.executeQuery();
    		if(rs.next()) {
    			return true;
    		}
    	}catch (Exception e) {
			System.out.println(e);
		}return false;
    }
    
    //3. 아이디찾기
    
    //4. 비밀번호 찾기
    
    //5. 내정보 호출
    public MemberDto info (String mid) {
    	try {String sql = "select mno,mid,memail,mimg from member where mid = ?;";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, mid);
    	rs=ps.executeQuery();
    	if(rs.next()) {
    		
    		MemberDto dto = new MemberDto(
    				LocalDateTime.now().toString(), //	LocalDateTime.now().toString() = 현재 날짜 시간 문자열 반환
    				rs.getInt(1), rs.getString(2),
    				rs.getString(3),  rs.getString(4));
    		return dto;
    	}
		} catch (Exception e) {System.out.println(e);}
    	return null;
    }
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
    
    	public boolean mupdate(String mimg ,int mno,String newMpwd ) {
    		try {String sql = "update member set mimg = ? ,mpwd = ? where mno = ? ;";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, mimg);
    		ps.setString(2, newMpwd);
    		ps.setInt(3, mno);
    		
    		int rs=ps.executeUpdate();
    		if(rs==1) {
    			return true;
    		}
    		
    		}catch (Exception e) {
				System.out.println(e);
			}
    		return false;
    	}
    //8. 회원탈퇴
    	//8-1 입력받은 회원의 비밀번호 찾기
    	public boolean FindPwd(String mpwd) {
    		try {String sql ="select mpwd from member where mpwd = ?;";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1,mpwd);
    		rs=ps.executeQuery();
    		if(rs.next()) {
    			return true;
    		}
				
			} catch (Exception e) {System.out.println(e);}
    		
    		return false;
    	}
    	public boolean DeletePwd(String mid) {
    		try {String sql ="delete from member where mid=?;";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, mid);
    		int rs = ps.executeUpdate();
    		if(rs==1) {
    			return true;
    		}
				
			} catch (Exception e) {System.out.println(e);}
    		return false;
    	}
    
    	
    	//9. 포인트 지급/사용에 대한  함수
    	public boolean setPoint(MpointDto dto) {
    		System.out.println(dto.getMpamount());
    		try {String sql = "insert into mpoint( mpno, mno , mpamount,mpcomment)values(?,?,?,?)";
    			ps=conn.prepareStatement(sql);
    			ps.setString(1, dto.getMpno());
    			ps.setInt(2, dto.getMno());
    			ps.setInt(3, dto.getMpamount());
    			ps.setString(4, dto.getMpcomment());
    			int rs=ps.executeUpdate();
    			if(rs==1) {
    				return true;
    			}
    		} catch (Exception e) {System.out.println(e.getStackTrace());}
    		return false;
    	}
    	
    	
    	//10. 내 포인트 확인 [로그인한 사람]
    	public int getPoint(int mno) {
		try {String sql = "select sum(mpamount) from mpoint where mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs=ps.executeQuery();
			if (rs.next()) {
					int sum = rs.getInt(1);
					return  sum;
			}else {return 0;}
				
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
    		return 0;
    	}
    	//11. 내 포인트 사용 내역
    	public List<MpointDto> getPointlist(int mno){
    		List<MpointDto> list = new ArrayList<>();
		try {String sql="select mpcomment from mpoint where mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs=ps.executeQuery();
			while(rs.next()) {
				MpointDto dto = new MpointDto(rs.getString(1), rs.getInt(2), 
						rs.getInt(3),
						rs.getString(4), rs.getString(5));
				list.add(dto);
				return list;
			}
				
			} catch (Exception e) {System.out.println(e.getStackTrace());}
    		return null;
    	}
}
