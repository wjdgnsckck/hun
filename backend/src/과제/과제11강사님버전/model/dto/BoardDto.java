package 과제.과제11강사님버전.model.dto;

public class BoardDto {	//이동객체 휘발성
	//1.필드
	 private int bno; 
	 private String btitle;
	 private String bcontent ;
	 private String bdate ;
	 private int bview;
	 private int mno ; //작성자가 회원번호 식별자
	 private String mid;
	 
	//2.생성자[ 1.빈생성자 2.풀생성자 + 추가생성자( 글쓰기 사용할때 필요한 생성자 , 글출력 생성자)
	 public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	
	public BoardDto(int bno, String btitle, String bcontent, String bdate, int bview, int mno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.mid = mid;
	}


	// + 글등록시 사용되는 생성자
	public BoardDto(String btitle, String bcontent, int mno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
	}
	// + 글 업데이트시 사용되는 생성자
	public BoardDto(int bno, String btitle, String bcontent) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
	}

	
		//3.메소드
	
	
	 
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", bview=" + bview + ", mno=" + mno + "]";
	}


	

	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public int getBview() {
		return bview;
	}


	public void setBview(int bview) {
		this.bview = bview;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	

	
	
	
}
