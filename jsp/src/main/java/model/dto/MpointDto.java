package model.dto;

public class MpointDto {
		
	private String mpno ;
	private int mno ;
	private int mpamount ;
	private String mpcomment ;
	private String mpdate ;
	
	public MpointDto() {
		// TODO Auto-generated constructor stub
	}

	public MpointDto(String mpno, int mno, int mpamount, String mpcomment, String mpdate) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
		this.mpdate = mpdate;
	}

	public String getMpno() {
		return mpno;
	}

	public void setMpno(String mpno) {
		this.mpno = mpno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdate=" + mpdate + "]";
	}
	
	
	
	
	
	
}
