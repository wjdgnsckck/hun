package model.dto;

public class VisitDto {
	
	//1. 필드
	private int	vno;
	private String vwriter ;
	private String vpwd ;
	private	String vcontent;
	private String vdate ;	
	
	
	//2. 생성자 [기본생성자,풀생성자]
	public VisitDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public VisitDto(int vno, String vwriter, String vpwd, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}
	//저장시 사용하는 생성자
	public VisitDto(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}

	//3. 메소드 기본셋팅 : 1 : getter 2 : setter 3.toString() 

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getvpwd() {
		return vpwd;
	}

	public void setvpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	@Override
	public String toString() {
		return "VisitDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent + ", vdate="
				+ vdate + "]";
	}
	
	
	
	
	
	
	

}
