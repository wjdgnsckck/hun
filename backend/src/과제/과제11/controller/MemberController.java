package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

	private static MemberController memberController =new MemberController ();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	

	//1.회원가입 [ 반환 : 1 성공 2:실패 [db오류 ] 3: 아이디중복실패 4. : 전화번호 중복실패
	public int singupLogic(String id,String pw,String name ,String phone) {
		// 아이디 중복체크
		if(MemberDao.getInstance().infoCheck("uid",id) ) return 3;
		if(MemberDao.getInstance().infoCheck("uphone",phone) ) return 4;
		
		System.out.println(id+pw+name+phone);
		//1. 객체화 : 5개 변수들이 이동 할때마다 매개변수의 코드 
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
		
		
		boolean result = MemberDao.getInstance().signupSQL(dto);
		if(result)return 1;
		else return 2;
		
		
		//2. 위에서 작성한 SQL를 DB연동객체에 대입
		
	}
		//0. 로그인된 회원의 번호를 저장하는 필드 = 웹/세션/쿠키
		
		
		//2.로그인
		public boolean loginLogic(String id,String pw) {
		
		boolean result = MemberDao.getInstance().loginSQL(id,pw);
		if(result) {return true;}
		return false;
		}
		//3.아이디 찾기
		public String idFindLogic(String name ,String phone) {
			String uid = MemberDao.getInstance().idFindSQL(name,phone);
			return uid;
		}
		//4.비밀번호 찾기
		public String pwFindLogic(String id , String phone) {
			String upw=MemberDao.getInstance().pwFindSQL(id,phone);
			return upw;
		}
		//5.회원탈퇴
		public boolean deleteLogic(String id,String pw) {
			boolean result= MemberDao.getInstance().deleteSQL(id, pw);
			return result;
		}
		//6.비밀번호수정 (아이디 비밀번호 같으면,찾기)
		public boolean update(String id,String pw,String pw2) {
			boolean result = MemberDao.getInstance().loginSQL(id,pw);
			if( result ) MemberDao.getInstance().updateSQL(id,pw,pw2);
			return result;
		}
		
		
	}

