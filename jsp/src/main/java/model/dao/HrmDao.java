package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao {
	private static HrmDao hrmDao = new HrmDao();
    public static HrmDao getInstanct () {return hrmDao;}
    private HrmDao() {};
    
    
    //1.입력값 저장하기
    public boolean signup(HrmDto dto) {
    	try { String sql = "insert into hrm(himg,hname,hphone,hrank)values(?,?,?,?);";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, dto.getHimg());
    	ps.setString(2, dto.getHname());
    	ps.setString(3, dto.getHphone());
    	ps.setString(4, dto.getHrank());
		int rs = ps.executeUpdate();
		if(rs==1) {return true;}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    
    
    //2.입력한 값 출력하기
    public 	ArrayList<HrmDto> hread() {
    	ArrayList<HrmDto> list = new ArrayList<HrmDto>();
    	try {String sql = "select * from hrm order by hdate desc;";
    	ps=conn.prepareStatement(sql);
    	rs=ps.executeQuery();
    	while(rs.next()) {
    		
    		HrmDto dto =new HrmDto(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
    	
    		list.add(dto);
    	}
    		
    	}catch (Exception e) {
		System.out.println(e);
		}
    	
    	return list;
    	
    }
    
    
    //3.수정하기
    
    
    //4.삭제하기
    
    
    
    
    
}
