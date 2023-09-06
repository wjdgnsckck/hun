package model.dto;

public class HrmDto {

	//필드
	private int hno ;
	private String himg ;
	private String hname ;
	private String hphone  ;
	private String hrank  ;
	private String hdate;
	//생성자
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}

	
	//출력하는 생성자
	public HrmDto(  String hname,String hphone, String hrank,String himg,  String hdate) {
		super();
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hrank = hrank;
		this.hdate = hdate;
	}


	//저장하는 생성자
	public HrmDto(String himg, String hname, String hphone, String hrank) {
		super();
		this.hphone = hphone;
		this.hname = hname;
		this.himg = himg;
		this.hrank = hrank;
	}

	//풀 생성자
	public HrmDto(int hno, String hphone, String hname, String himg, String hrank) {
		super();
		this.hno = hno;
		this.hphone = hphone;
		this.hname = hname;
		this.himg = himg;
		this.hrank = hrank;
	}






	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", hphone=" + hphone + ", hname=" + hname + ", himg=" + himg + ", hrank=" + hrank
				+ ", hdate=" + hdate + "]";
	}



	public String getHrank() {
		return hrank;
	}






	public void setHrank(String hrank) {
		this.hrank = hrank;
	}

	public String getHdate() {
		return hdate;
	}


	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	
	//메소드
	
	
	
	
}
