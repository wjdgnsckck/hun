package 과제.과제11.model.dto;

public class MemberDto {

		//1. 필드
	private int uno;
	private String uid;
	private String upw;
	private String uname;
	private String uphone;
		//2. 생성자
			//1.기본생성자
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
			//2. 풀 생성자
		public MemberDto(int uno, String uid, String upw, String uname, String uphone) {
			super();
			this.uno = uno;
			this.uid = uid;
			this.upw = upw;
			this.uname = uname;
			this.uphone = uphone;
			}
	//3. 메소드 
			//1.getter and setter

		public int getUno() {
			return uno;
		}
		public void setUno(int uno) {
			this.uno = uno;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getUpw() {
			return upw;
		}
		public void setUpw(String upw) {
			this.upw = upw;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getUphone() {
			return uphone;
		}
		public void setUphone(String uphone) {
			this.uphone = uphone;
		}
		@Override
			//2. tostring
		public String toString() {
			return "MemberDto [uno=" + uno + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphone=" + uphone
					+ "]";
		}
	
	
		
	
	
	
}
