package library.model.dto;

public class LibraryDto {
	private int lno ;
	private String lname ;
	private String lphonenumber;
	public LibraryDto() {
		// TODO Auto-generated constructor stub
	}
	public LibraryDto(int lno, String lname, String lphonenumber) {
		super();
		this.lno = lno;
		this.lname = lname;
		this.lphonenumber = lphonenumber;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLphonenumber() {
		return lphonenumber;
	}
	public void setLphonenumber(String lphonenumber) {
		this.lphonenumber = lphonenumber;
	}
	@Override
	public String toString() {
		return "LibraryDto [lno=" + lno + ", lname=" + lname + ", lphonenumber=" + lphonenumber + "]";
	}
	
}
