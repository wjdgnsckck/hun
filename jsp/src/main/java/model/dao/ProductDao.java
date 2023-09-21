package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    
    
    
    
    //3.제품 찜하기 등록
    public boolean setWish(int mno,int pno) {
    	try {
    		String sql = getWish(mno, pno) ? 
    					"delete from pwishList where mno=? and pno=?" :
    					"insert into pwishList values(? , ?)" ;
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, mno);
    		ps.setInt(2, pno);
    		int rs=ps.executeUpdate();
    		if(rs==1) {
    			return true;
    		}
   
		} catch (Exception e) {System.out.println("setWish():"+e);}
    	return false;
    }
    
    //4.제품 찜하기 취소
    /*rs 사용 중일때는 rs 객체를 새로 생성해줘야한다!. 여기서는 rs가 끝나고 재호출해서 써도 괜찮다.*/
    public boolean getWish(int mno , int pno) {
    	try {	String sql="select * from pwishList where mno=? and pno=?";
    		ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pno);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
			} catch (Exception e) {
			System.out.println("getWish"+e);
		}return false;
    
    }
    
    //5. 제품 찜하기 상태 출력
    public List<ProductDto> getWishProductList(int mno){
    	List<ProductDto>list=new ArrayList<>();
    	try {
    		String sql = "select pno from pwishList list where mno =" +mno;
    		ps=conn.prepareStatement(sql);
    		rs=ps.executeQuery();
    		
    		while(rs.next()) {list.add(findByPno(rs.getInt("pno")));}
    		return list;
    		
		} catch (Exception e) {System.out.println("getWishProductList"+e);return null;}
    }
    
    
    
    
    
    
    
    
    //3. 제품 수정
    
    
    
    
    
    
    
    //4. 제품 삭제
    
    /*rs 사용 중일때는 rs 객체를 새로 생성해줘야한다!. 그래서 resultset rs2를 만들었다.*/
    public Map<Integer, String> getProductImg(int pno){
        try {
           Map<Integer, String> imglist = new HashMap<>();
           String sql = "select * from productimg where pno = "+pno;
           PreparedStatement ps2 = conn.prepareStatement(sql);
           ResultSet rs2=ps2.executeQuery();
           while (rs2.next()) {
              imglist.put(rs2.getInt("pimgno"),rs2.getString("pimg"));
           }return imglist;
          
       } catch (Exception e) {System.out.println(e);}return null;
     }
     
     
     public ProductDto findByPno(int pno) {
        try {
           ProductDto dto =new ProductDto();
          String sql = "select * from product p natural join pcategory pc natural join member m  where pno="+pno;
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          if(rs.next()) {
             dto = new ProductDto(
            rs.getInt("pcno"), rs.getString("pcname"),rs.getInt("pno"),
            rs.getString("pname"),rs.getString("pcontent"), rs.getInt("pprice"),
            rs.getInt("pstate"),rs.getString("pdate"),rs.getString("plat"),
            rs.getString("plng"),rs.getInt("mno"), getProductImg(rs.getInt("pno")),
            rs.getString("mid")
            );
          }return dto;
        
        } catch (Exception e) {System.out.println(e);}
        return null;
     }
     
        //1. N개 제품들을 최신순으로 출력하는 함수
     public  List<ProductDto>findByTop (int count){
        List<ProductDto> list =new ArrayList<>();
        try {String sql = "select * from product order by pdate desc limit ?";  
        ps=conn.prepareStatement(sql);
        ps.setInt(1, count);
        rs=ps.executeQuery();
           while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
           return list;
       } catch (Exception e) {System.out.println(e);}
        return null;
     }


     public  List<ProductDto>  findByLatLng(String west,String east,String south,String north){
    	 System.out.println(east);
    	 System.out.println(west);
    	 System.out.println(south);
    	 System.out.println(north);
    	 List<ProductDto> list =new ArrayList<>();
        try { 
        String sql = "select pno from product where plat between ? and ? and plng between ?and ? order by pdate;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, east); ps.setString(2, west);
        ps.setString(3, south); ps.setString(4, north);
        rs=ps.executeQuery();
       while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
       }
       
        catch (Exception e) {System.out.println(e);}
       System.out.println(list);
        return list;
     }

       public  List<ProductDto> findByAll(){
         List<ProductDto> list =new ArrayList<>();
          try { 
          String sql = "select * from product order by pdate";
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
         }
         
          catch (Exception e) {System.out.println(e);}
         
          return list;
       }
}
// Map<Integer, String> : map객체명.keySet() : map 객체내 모든키 호출
// --------- get(i) : map컬렉션 set컬렉션은 인덱스 없음.
// --------- get(키) : SET컬랙션 MAP 컬랙션은 인덱스가 없으므로 키 값으로 호출한다.
