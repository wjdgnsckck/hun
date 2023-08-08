package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {
	
	private static MainPage mainPage=new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	//0.
	private Scanner sc=new Scanner(System.in);
		//1.메인메뉴
	public void main() {
		while(true) {
			System.out.println("\n\n=======회원제 커뮤니티=======");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.회원탈퇴 6.비밀번호 수정 선택 : ");
			try {
			int ch=sc.nextInt(); // 만약에 타입과 일치하지 않는 갑을 입력하면 InputMismatchException
			if(ch==1) {signupView();}
			if(ch==2) {loginView();}
			if(ch==3) {idFind();}
			if(ch==4) {pwFind();}
			if(ch==5) {delete();}
			if(ch==6) {update();}
			}
			catch (Exception e) {
				System.out.println("경고 ] 잘못입력했습니다.");
				sc= new Scanner(System.in); //입력객체의 메모리를 새롭게 만들어주기
			}//c end
			
			
		}//w end
	}//m end
		//2.회원가입
	public void signupView() {
		System.out.println("아이디 : "); String id=sc.next();
		System.out.println("비밀번호 : "); String pw=sc.next();
		System.out.println("이름 :");  String name=sc.next();
		System.out.println("전화번호 :"); String phone=sc.next();
		
		int result=
				MemberController.getInstance().singupLogic(id, pw, name, phone);
		if(result==1) {System.out.println("안내] 회원가입이 성공했습니다. 감사합니다.");}
		else if(result==2){System.out.println("경고 ] 회원가입 실패. 관리자에게 문의");}
		else if(result==3){System.out.println("경고 ] 회원가입 실패. 아이디중복");}
		else if(result==4){System.out.println("경고 ] 회원가입 실패. 전화번호중복");}
	}
		//3.로그인
	public void loginView() {
		System.out.println("-----로그인 페이지--------");
		System.out.println("아이디 : "); String id=sc.next();
		System.out.println("비밀번호 : "); String pw=sc.next();
		boolean result = MemberController.getInstance().loginLogic(id,pw);
		if(result) {System.out.println("안내]로그인성공");}
		else {System.out.println("안내]로그인 실패");}
	}
	
	public void idFind() {
		System.out.println("--------아이디 찾기--------");
		System.out.println("이름 : "); String name = sc.next();
		System.out.println("전화번호 :"); String phone = sc.next();
		String uid=MemberController.getInstance().idFindLogic(name,phone);
		System.out.println("찾은 아이디 :"+uid);
		
	}
	public void pwFind() {
		System.out.println("--------비밀번호--------");
		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("전화번호 :"); String phone = sc.next();
		String upw = MemberController.getInstance().pwFindLogic(id,phone);
		System.out.println("찾은 비밀번호 :"+upw);
	}
	public void delete() {
		System.out.println("----------회원탈퇴--------");
		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("비밀번호 : "); String pw=sc.next();
		 boolean result =  MemberController.getInstance().deleteLogic(id, pw);
		 if(result) {System.out.println("성공적으로 회원탈퇴 했습니다.");}
		 
		 else {System.out.println("오류) 아이디 비밀번호가 맞지 않습니다.");}
	}
	
	public void update() {
		System.out.println("----------아이디비밀번호확인--------");
		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("비밀번호 : "); String pw=sc.next();
		System.out.println("수정될 비밀번호 : "); String pw2=sc.next();
		boolean result = MemberController.getInstance().update(id, pw,pw2);
		if(result) {
			System.out.println("비밀번호 수정 성공! : "+pw2);
		}
		else {System.out.println("오류)입력된 정보 오류");}
		
	}
	
	
}
