package 과제.과제11강사님버전.model.dao;

import java.util.ArrayList;

import 과제.과제11강사님버전.model.dto.BoardDto;
import 과제.과제11강사님버전.model.dto.MemberDto;

public class BoardDao extends Dao {
	// 5 boardWrite		게시물쓰기 페이지
	private static BoardDao boardDao = new BoardDao();
    public static BoardDao getInstanct () {return boardDao;}
    private BoardDao() {};
    
		public boolean boardWrite( BoardDto boardDto) {
			try {
				//1.
				String sql = "insert into board(btitle,bcontent,mno) value(?,?,?)";
				//2.
				ps=conn.prepareStatement(sql);
				//3.
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				ps.setInt(3, boardDto.getMno());
				//4.
				int row = ps.executeUpdate();
				if(row==1)return true;
				
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		// 10 boardPrint		모든 게시물 출력
		public ArrayList<BoardDto> boardPrint() {
			ArrayList<BoardDto> list =new ArrayList<>();	//여러개 BoardDto 를 지정할 리스트객체 선언
			try {
				
				//String sql = "select * from board order by bdate desc;"; //1. 최신순으로 모든 게시물 호출 //조인사용전 sql 문
				String sql ="select b.*,m.mid from member1 m natural join board b  order by b.bdate desc";
			    ps = conn.prepareStatement(sql);
		         
		         // 3.
		         // 4. 검색결과의 레코드를 여러 개 조작하기 위해 resultSet 객체 반환
		         rs = ps.executeQuery();

		         
		         // 5. 여러 개의 레코드 조회 [rs.next() : 다음 레코드 이동(존재하면 true, 존재하지않으면 false)]
		         while( rs.next() ) {
		            // 마지막 레코드까지 하나씩 레코드 이동
		        	 BoardDto boardDto = new BoardDto(
		                     rs.getInt(1), rs.getString(2), rs.getString(3), 
		                     rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
		        	 list.add(boardDto);
		         }
		          
		       
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			return list;
		} // p ends
		
		// 11 boardView		개별 게시물 출력
		public BoardDto boardView(int bno) {
			
			try {
				String sql  = "select b.* , m.mid from board b natural join member1 m where b.bno=?;";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
				rs=ps.executeQuery();
				//1. 1개조회 if 여러개 조희 while
				if(rs.next()) {
					boardViewCount(bno);
					//레코드 한개를 dto화
					 BoardDto boardDto = new BoardDto(
		             rs.getInt(1), rs.getString(2), rs.getString(3), 
		             rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
					 
		        return boardDto;
				}
			}catch (Exception e) {System.out.println(e);}
			return null;
		}
		//11-2. 조회수 증가
		public void boardViewCount(int bno) {
			try {
				String sql = "update board set bview=bview+1 where bno=?;";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, bno);
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		// 12 boardUpdate	게시물 수정 [ 인수 : bno , title, content ] 
		public boolean boardUpdate(BoardDto boardDto) {
			try {
				String sql="update board set btitle =?, bcontent =?  where bno=?"; //1
				ps=conn.prepareStatement(sql);//2
				ps.setInt(3, boardDto.getBno());		//3
				ps.setString(1, boardDto.getBtitle());
				ps.setString(2, boardDto.getBcontent());
				int row = ps.executeUpdate();
				//select ->rs =ps.executeQuery(조회할때는)    //insert , update , delete -> int row 로 받아야함.
				if(row==1) return true;	//결과에 따른 제어
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		// 13 boardDelete	게시물 삭제 [ 인수 : bno ]
		public boolean boardDelete(int bno) {
			try {
				String sql="delete from board where bno= ?;";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, bno);
				int row =ps.executeUpdate();
				if(row==1) {return true;}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return false;
			
		}
}

/*
 System.out.println(rs);
		            System.out.println(rs.getString(1)+"\t");	
		            System.out.println(rs.getString(2)+"\t");	
		            System.out.println(rs.getString(3)+"\t");
		            System.out.println(rs.getString(4)+"\t");
		            System.out.println(rs.getString(5)+"\t");
		            System.out.println(rs.getString(6)+"\t");
 */