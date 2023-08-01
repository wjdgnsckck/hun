package java1.day14.Ex_1;

public class Ex_1실행 {
	
	public static void main(String[] args) {
		
		//1.Phone 부모 객체
		Phone phone = new Phone();
		System.out.println(phone.color);
		System.out.println(phone.model);
		//System.out.println(phone.wifi); //오류 발생 : 해당 객체는 부모객체 이고 해당 필드는 자식 클래스 맴버이므로 불가능하다.
		
		phone.bell();
		phone.sendVoice("여보세요");
		phone.receiveVoice("안녕하세요 저는 홍길동입니다.");
		phone.hangup();
		//phone.setWifi(true);	//오류 발생 : 해당 객체는 부모객체 이고 해당 메소드는 자식 클래스의 맴버 이므로 불가능
		
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		//Phone으로부터 상속받은 필드 읽기
		System.out.println("모델 : "+myPhone.model);	//해당 객체의 부모클래스 맴버 이므로 사용가능
		System.out.println("색상:"+myPhone.color);	//해당 객체의 부모클래스 맴버 이므로 사용가능
		System.out.println("와이파이 상태 : "+myPhone.wifi);	//해당 객체의 맴버 이므로 사용가능
		

		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요 저는 홍길동입니다.");
		myPhone.hangup();		//해당 객체는 자식객체 이므로 부모객체의 맴버 사용 가능
		myPhone.setWifi(true);	//오류 발생없는 이유 : 해당 객체는 자식객체 이므로 메소드는 자식클래스의 맴버이므로 사용가능
		myPhone.internet();
	}
}
