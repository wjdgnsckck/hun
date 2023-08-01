package java1.day13.Ex2;

import java1.day13.Ex2.View.MainPage;

public class AppStart {
	public static void main(String[] args) {
		//- 다른클래스/객체에 있는 메소드 호출 하는 방법
		
		//1.호출할 메소드가 있는 클래스의 객체를 만들어서 객체를 이용한 메소드 호출
		//MainPage mainPage =new AppStart();
		//mainPage.mainPage();
		
		//2.호출할 메소드가 정적[static]메소드 이면 객체 없이 호출
		//MainPage.mainPage();
		//3.호출할 메소드의 클래스가 싱글톤이면 싱글톤 호출후 메소드 호출
		MainPage.getInstance().mainPage();
		//MainPage : 클래스
			//MainPage.getInstance() : 클래스 안에 있는 정적맴버 호출후 반환
			//반환: 싱글톤을 반환받는다
				//MainPage.getInstance().mainPage(); : 싱글톤객체를 이용한 메소드 호출
	}
	
}
