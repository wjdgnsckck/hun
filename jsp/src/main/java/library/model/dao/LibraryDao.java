package library.model.dao;

import java.util.ArrayList;

import library.model.dto.LibraryDto;
import model.dao.Dao;

public class LibraryDao extends Dao{
   
   private static LibraryDao libraryDao = new LibraryDao();
    public static LibraryDao getInstanct () {return libraryDao;}
    private LibraryDao() {};
    
    public boolean entrance(int lno,String lname,String lphonenumber) {
        try {
           String sql = "update library set lname=?,lphonenumber=?  where lname is null and lno=?  ;";
           ps=conn.prepareStatement(sql);
           ps.setString(1, lname);
           ps.setString(2, lphonenumber);
           ps.setInt(3,lno);
           int rs = ps.executeUpdate();
           if(rs==1) {return true;}
           
        }catch (Exception e) {
       System.out.println(e);}
        return false;
     }
    
    public boolean leave(int lno,String getphone) {
        try {
       String sql = "update library set Lname = NULL ,lphonenumber = NULL where lno = ? and lphonenumber = ?";
       ps = conn.prepareStatement(sql);
       ps.setInt(1, lno);
       ps.setString(2, getphone);
       
       return (ps.executeUpdate() == 1) ? true:false;
          
    } catch (Exception e) {
       // TODO: handle exception
       System.out.println("퇴실 에러"+e);
    }
        return false;
     }
    public ArrayList<LibraryDto> getSitList()
    {
       ArrayList<LibraryDto> res = new ArrayList<>();
       try {
         String sql = "select * from library";
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next())
         {
            res.add(new LibraryDto(rs.getInt(1),rs.getString(2),rs.getString(3)));
            
         }
         return res;
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("좌석불러오기 에러"+e);
      }
       return null;
       
    }

}