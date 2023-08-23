package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao{
	private static VisitDao visitDao = new VisitDao();
    public static VisitDao getInstanct () {return visitDao;}
    private VisitDao() {};
    
    //1.저장 [ 인수 : 저장할 내용이 담긴 dto , 리턴 : 성공/실패= true/false ] 
    public boolean vwriter(VisitDto dto) {
    	//0. try{} catch(){}
    	try { String sql = "insert into visitlog(vwriter,vpwd,vcontent) values(?,?,?);";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, dto.getVwriter());
    		ps.setString(2, dto.getvpwd());
    		ps.setString(3, dto.getVcontent());
    		int rs=ps.executeUpdate();
    		while(rs>0) {
    			return true;
    		}
    	
    	}catch (Exception e) {
			System.out.println(e);
			return false;
		}
    	return false;
    
    }
    //2.호출	[ 인수 : x  , 리턴 : 여러개의 등록 dto ] 
    public ArrayList<VisitDto> vread(){
    	ArrayList<VisitDto> list =new ArrayList<VisitDto>();
    	try {
    		String sql = "select * from visitlog order by vdate desc;";
    		ps=conn.prepareStatement(sql);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			//* 레코드/하나 줄/하나 행/하나 방문록 /하나 DTO
    			//레코드 --> DTO 변환
    			VisitDto dto = new VisitDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
    			list.add(dto);
    		}
    	}catch (Exception e) {
		System.out.println(e);
		}
    	return list;
    }
    //3.수정 [ 인수 : 수정할번호(int), 수정할 등록내용(string) , 리턴 : 성공/실패= true/false ]
    public boolean vupdate() {return false;}
    //4.삭제 [ 인수 : 삭제할방문록번호 , 리턴 : 성공/실패 true / false ]
    public boolean vdelete() {return false;}

}
