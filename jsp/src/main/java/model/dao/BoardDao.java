package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	private static BoardDao boardDao = new BoardDao();
    public static BoardDao getInstanct () {return boardDao;}
    private BoardDao() {};
    
    //1. 글쓰기
    public boolean bwrite(BoardDto boardDto) {
    	try {String sql="insert into board(btitle,bcontent,bfile,mno,bcno)values(?,?,?,?,?);";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, boardDto.getBtitle());
    	ps.setString(2, boardDto.getBcontent());
    	ps.setString(3, boardDto.getBfile());
    	ps.setInt(4, boardDto.getMno());
    	ps.setInt(5, boardDto.getBcno());
    	int rs = ps.executeUpdate();
    
    	if(rs==1) {
    		return true;
    	}
		
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
    //2. 모든 글 출력
    public ArrayList<BoardDto> getList(){
    	
    	//* 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트
    	ArrayList<BoardDto> list =new ArrayList<>();
    	
    	
    	try {String sql = " select b.*, m.mid  , m.mimg , bc.bcname\r\n"
    			+ "    from board b \r\n"
    			+ "			natural join bcategory bc \r\n"
    			+ "			natural join member m order by bdate desc;";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9), rs.getString(10), rs.getString(11));
				list.add(dto);
				System.out.println(dto);
			}
		} catch (Exception e) {
		System.out.println(e);
		}
    	System.out.println(list);
		return list;
    }
    
    //3. 개별 글 출력
    
    //4. 게시물 수정
    
    //5. 게시물 삭제
    
    //6. 조회수 증가
}
