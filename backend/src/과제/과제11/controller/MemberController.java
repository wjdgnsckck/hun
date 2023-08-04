package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

	private static MemberController memberController =new MemberController ();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	

	//1.회원가입
	public boolean singupLogic(String id,String pw,String name ,String phone) {
		
		System.out.println(id+pw+name+phone);
		//1. 객체화 : 5개 변수들이 이동 할때마다 매개변수의 코드 
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
		
		
		boolean result = MemberDao.getInstance().signupSQL(dto);
		return result;
		
		
		//2. 위에서 작성한 SQL를 DB연동객체에 대입
		
	}
		
		//2.로그인
		public boolean loginLogic(String id,String pw) {
		
		boolean result = MemberDao.getInstance().loginSQL(id,pw);
		return result;
		}
	}

