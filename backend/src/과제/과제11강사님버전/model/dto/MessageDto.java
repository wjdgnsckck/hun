package 과제.과제11강사님버전.model.dto;

public class MessageDto {

	//1.필드
	private int pno ;
	private  String bno; 
	private  int mno ; 
	private  String pcontent; 
	private  String pdate ;
	private  String  preply; 
	private String mid;
	//2.생성자
	public MessageDto() {}
	
	//쪽지 확인 생성자
	
	public MessageDto(int pno, String bno, int mno, String pcontent, String pdate, String preply, String mid) {
		super();
		this.pno = pno;
		this.bno = bno;
		this.mno = mno;
		this.pcontent = pcontent;
		this.pdate = pdate;
		this.preply = preply;
		this.mid = mid;
	}
	
	
	

	public MessageDto(int pno, int mno, String pcontent, String pdate, String mid) {
		super();
		this.pno = pno;
		this.mno = mno;
		this.pcontent = pcontent;
		this.pdate = pdate;
		this.mid = mid;
	}

	//3.메소드
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPreply() {
		return preply;
	}
	public void setPreply(String preply) {
		this.preply = preply;
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "MessageDto [pno=" + pno + ", bno=" + bno + ", mno=" + mno + ", pcontent=" + pcontent + ", pdate="
				+ pdate + ", preply=" + preply + ", mid=" + mid + "]";
	}

	
	
	
	
	
	
	
	
}
