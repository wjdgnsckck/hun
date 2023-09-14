package model.dao;

import java.sql.Statement;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao productDao = new ProductDao();
    public static ProductDao getInstanct () {return productDao;}
    private ProductDao() {};
    
    
    
    
    //1. 제품 등록
    public boolean register(ProductDto dto) {
    	//1-1[제품 등록]
    	try {String sql="insert "
    			+ " into product(pcno,pname,pcontent,pprice,plat,plng,mno)\r\n"
    			+ " values(?,?,?,?,?,?,?) ;" ;
    		//* sql insert 후 자동생성된 pk번호를 반환하는 방법
    			//prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //생성된 식별키를 반환한다!
				//rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk] 반환해서 resultset[rs]에 대입
    		ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); 
			ps.setInt(1, dto.getPcno()); ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcontent()); ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat()); ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			
			int count = ps.executeUpdate();
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk] 반환해서 resultset[rs]에 대입
			rs.next();					// 반환된 식별키를 rs에 대입한다.
										// 반환된 결과레코드로 1번 이동[ 하나의 제품 식별키 필요]
			if(count==1) { // 만약에 제품등록 1개 등록했으면
				//1.dto에 저장된 이미지 만큼
				for(int key:  dto.getImgList().keySet()) {
					sql="insert into productimg(pimg,pno)values(?,?);";
					ps=conn.prepareStatement(sql);
					ps.setString(1, dto.getImgList().get(key));
					ps.setInt(2, rs.getInt(1));
				 	ps.executeUpdate();
				}
				return true; //제품등록과 이미지 등록 성공 했을때.
			}
			
		}//t end
    	catch (Exception e) {System.out.println(e);}
    	
    	return false;
   }
    
    
    
    
    
    //2. 제품 전체 출력
    
    
    
    
    
    //3.제품 개별 조회
    
    
    
    
    
    
    
    //3. 제품 수정
    
    
    
    
    
    
    
    //4. 제품 삭제







}
// Map<Integer, String> : map객체명.keySet() : map 객체내 모든키 호출
// --------- get(i) : map컬렉션 set컬렉션은 인덱스 없음.
// --------- get(키) : SET컬랙션 MAP 컬랙션은 인덱스가 없으므로 키 값으로 호출한다.
