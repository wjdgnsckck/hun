package model.dto;

public class MemberDto {
		//1.필드
			//1-1 DB에 있는 필드
	private int mno  ;
	private String mid ;
	private String mpwd ;
	private String memail ;
	private String 	mimg ;
			//1-2 DB 없는 필드
	private String loginDatetimbe; // 로그인 시간
	

	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	// 로그인 객체를 만들 생성자 [ 패스워드 제외 ]
	//**생성자 문제점!! 필드명이 달라도 타입이 같으면 오류처리!
	
	public MemberDto(String loginDatetimbe,int mno, String mid, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDatetimbe = loginDatetimbe;
	}
	
	//회원가입시 사용하는 생성자
	
	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}



	


	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}

	
	public String getLoginDatetimbe() {
		return loginDatetimbe;
	}

	public void setLoginDatetimbe(String loginDatetimbe) {
		this.loginDatetimbe = loginDatetimbe;
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

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDatetimbe=" + loginDatetimbe + "]";
	}

	
	
}
