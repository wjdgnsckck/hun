package java1.day11.EX5디자인패턴2.controller;


import java.util.UUID;

import java1.day11.EX5디자인패턴2.model.dao.MemberDao;
import java1.day11.EX5디자인패턴2.model.dto.MemberDto;

public class MemberController { // 기능처리(로직) 담당하는 클래스 // controller -> java
	static String id="";
	// 1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	// 2. 외부로부터 싱글톤 호출할수 있도록 get~~
	public static MemberController getInstance() { return memberController; }
	// 3. 외부에서 객체 생성 차단 위한 생성자 잠금
	private MemberController() { }
	
	public boolean singupLogic( String id , String pw , String name , String phone , int age) {
		MemberDto m = new MemberDto(id, pw, name, phone, age); 
		for( int i = 0 ; i< MemberDao.memberList.length ; i++ ) {
			if( MemberDao.memberList[i] == null ) { 
				MemberDao.memberList[i] = m; return true; // 회원가입 성공 
			}
		}  // for end 
		return false; // 회원가입 실패
		
	}
	public boolean loginLogic(String id, String pw) {
	
		for( int i = 0 ; i<MemberDao.memberList.length; i++ ) {
	
		if( MemberDao.memberList[i] != null && 				// 1. i번재 인덱스의 값이 null 아니면서 [ 회원이 있는곳만 비교 ]
				MemberDao.memberList[i].getId().equals(id) &&		// 2. i번째 인덱스의 회원객체 의 id가 입력한 id와 같고
				MemberDao.memberList[i].getPw().equals(pw) ) {	// 3. i번째 인덱스의 회원객체 의 pw가 입력한 pw와 같으면  
			//loginIndex = i; // 정적 멤버 변수에 로그인 성공한 인덱스를 넣어두기 -> 추후에 사용할 목적
			return true;
		}//if end
	}//for end
		return false;
}//login end
	
	 public boolean  findIdLogic(String name , String phone) {
		for(int i = 0 ; i<MemberDao.memberList.length ; i++) {
			if(MemberDao.memberList[i]!=null) {
				if(MemberDao.memberList[i].getName().equals(name)&&MemberDao.memberList[i].getPhone().equals(phone)) { 
					id=MemberDao.memberList[i].getId();	
				return true;}
				
			}
		}
		id="";
		return false;}
	
	 
	public boolean findPwLogic(String id , String phone) {
		for(int i = 0 ; i<MemberDao.memberList.length; i++) {
			if(MemberDao. memberList[i]!=null) {
				if(MemberDao.memberList[i].getId().equals(id)&&MemberDao.memberList[i].getPhone().equals(phone)) {
				return true;}
	     }

	
}//for end
		return false;
	} //public end
}//main end