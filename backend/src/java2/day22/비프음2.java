package java2.day22;

import java.awt.Toolkit;

public class 비프음2  extends Thread{ // extends : 연장하다,상속
	//장점!!!:바로 start할수있다
	//implements와 차이점 : 상속을 더 받을수없다!(단점)
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<5; i++) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
			//* 0.5초간 딜레이 [ 메인스레드 잠깐 멈춤 ] - 밀리초(1/1000)초s
			try{Thread.sleep(500);}catch (Exception e) {
				System.out.println(e);
			}
		}
}
}
