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
    //2-2 게시물 수 출력
    public int getTotalSize( int bcno) {
    	try {
			String sql = "select count(*) from board b";
			// 만약에 전체보기 가 아니면 [ 카테고리별 개수]
			if(bcno!=0) { sql += " where b.bcno = "+bcno;}
			
			ps=conn.prepareStatement(sql);
			rs= ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return 0;
    } 
    
    
    //2. 모든 글 출력
    public ArrayList<BoardDto> getList(int bcno,int listsize,int startrow){
    	
    	//* 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트
    	ArrayList<BoardDto> list =new ArrayList<>();
    	try {
    		String sql = " select b.*, m.mid  , m.mimg , bc.bcname from board b "
        			+ "	natural join bcategory bc "
        			+ "	natural join member m ";
    		// 만약에 카테고리를 선택했으면 [ 전체보기가 아니면 ]
    		if(bcno!=0) { sql += " where b.bcno = "+ bcno ;}
    		
    		// 뒷부분 공통 SQL
    		sql += " order by b.bdate desc limit ? , ?";
    		
			ps=conn.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9), rs.getString(10), rs.getString(11));
				list.add(dto);
						}
		} catch (Exception e) {
	
		}
    	
		return list;
    }
    
    //3. 개별 글 조회
    public BoardDto getBoard(int bno) {
    	view(bno);
    	try {String sql = 
    			" select b.* , m.mid , m.mimg , bc.bcname\r\n"
    			+ "from board b\r\n"
    			+ "natural join member m \r\n"
    			+ "natural join bcategory bc\r\n"
    			+ "where b.bno = ?;";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, bno);
    		rs=ps.executeQuery();
    		if (rs.next()) {
    			BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9), rs.getString(10), rs.getString(11));
    			
    			return dto;
    		}
			
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    	return null;
    }
    
    //4. 게시물 수정
    public boolean bupdate(BoardDto dto) {
    	try {String sql = "update board set  btitle=? , bcontent=? , bfile=? , bcno=? where bno=?;";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, dto.getBtitle());
    	ps.setString(2, dto.getBcontent());
    	ps.setString(3, dto.getBfile());
    	ps.setInt(4, dto.getBcno());
    	ps.setInt(5, dto.getBno());
    	int rs = ps.executeUpdate();
    	if(rs==1) {return true;}
		} catch (Exception e) {
		System.out.println(e);
		}
    	
    	return false;
    }
    //5. 게시물 삭제
    public boolean bdelete (int bno) {
    	try {String sql = "delete from board where bno = ?;";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, bno);
    	int rs = ps.executeUpdate();
    	if(rs==1) {return true;}
		} catch (Exception e) {System.out.println(e);}return false;
    }
    
    
    //6. 조회수 증가
    public boolean view(int bno) {
    	try {String sql ="update board set bview =bview+1 where bno = ?;";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, bno);
    		int rs=ps.executeUpdate();
    		if(rs==1) {
    			return true;
    		}
    			
			
		} catch (Exception e) {
			System.out.println(e);
		}
    	return false;
    }
}
