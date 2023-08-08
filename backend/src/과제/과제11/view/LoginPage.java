package 과제.과제11.view;

import java.util.Scanner;

public class LoginPage {
	// 0.싱글톤
	private LoginPage loginPage = new LoginPage();
	public LoginPage getInstance() {return loginPage;};
	private LoginPage() {}
	// 0.입력객체
	private Scanner sc=new Scanner(System.in);
	// 1.loginMenu : 로그인했을때 메뉴 페이지
	public void loginMenu() {}
	// 2. info : 회원정보 페이지
	public void info() {}
	// 3.infoUpdate :회원정보수정 페이지
	public void infoUpdate() {}
	// 4.infoDelete :회원탈퇴 페이지
	public void infoDelete() {}
	// 5. write :게시물쓰기 페이지
	public void write() {}	
	// 6. print :모든 게시물 출력
	public void print() {}
	// 7. view :개별 게시물 출력
	public void view() {}
	// 8. update :게시물 수정
	public void update() {}
	// 9. delete :게시물 삭제
	public void delete() {}
}
