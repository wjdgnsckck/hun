package 과제8;

// 목적 : 설계도, 객체의모델
public class Member {
	//1.필드 : 객체의 정보를 저장하는곳
	String  id;		//초기값/처음에 대입 이 없을때 기본값[정수0실수0.0불false참조null]
	String password;
	String name;
	String phone;
	int age;
	
	//클래스 빈공간 클릭 ->우클릭 ->아래에서 3번째
	//2.생성자	
	public Member() {}	//0. 빈 [매개변수 없는 ] 생성자
			//2. 매개변수 5개 정의한 생성자
	public Member (String id , String password , String name , String phone , int age) {
		this.id=id; 
		this.password=password;
		this.name=name;
		this.phone=phone;
		this.age=age;
	} //1.매개변수5개 정의한 생성자
	
	/*
	public Member (String id , String password , String name , String phone ) {}			//2.매개변수 4개 정의한 생성자
	public Member (String id , String password , String name ) {}								//3.매개변수 3개 정의한 생성자
	public Member (String id , String password ) {}													//4.매개변수 2개 정의한 생성자
	public Member (String id ) {}																				//5.매개변수 1개 정의한 생성자
	//public Member (String pw ) {}	 타입이 같고 변수개수가 같으면 오류		
	public Member (int age) {}																				//매개변수 타입이 달라서 가능
	*/
	//3.메소드
	
}

/*
주제: 회원제 시스템
		0.저장
				아이디,비밀번호,이름,전화번호
				* 5가지(서로다른타입) 필드/변수/데이터 를 하나의 묶음방법
				 --> 문자열 이용 : "아이디,비밀번호,이름,전화번호,나이"	:,쉼표 이용한 필드 구분
				 --> 클래스(필드) 이용 : 
				 		1.클래스 설계 = 새로운 클래스.java 파일 생성
				 		2.클래스 맴버 구성 : 필드 , 생성자 , 메소드
				 *하나로 묶인(기준동일=타입동일) 여러개 저장???
				 --> 문자열 배열 : String[] 문자열배열=new String[100];
				 --> 클래스 배열 : Member[] 객체배열=new Member[100];
		1.초기 메뉴 [24시간]
			1.회원가입	2.로그인
			
		2. 조건 기능
			1.회원가입
				1.아이디,비밀번호,이름,전화번호,나이 각 입력받아 저장
				2.Member 객체화
				3.객체를 배열 저장
			2.로그인
				1.아이디 , 비밀번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
						-만약에 동일한 값 있으면 로그인 성공
						-아니면 실패

회원가입,로그인


*/
