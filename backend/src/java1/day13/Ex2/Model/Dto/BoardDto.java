package java1.day13.Ex2.Model.Dto;

public class BoardDto {
	//싱글톤(공유X) : 게시물 1개당 DTO 1개 이기 때문에 여러 DTO필요
	
	
	//1.필드
		//1.작성자(문자열),내용(문자열),조회수(int)
	private String writer;
	private String content;
	private int view;
	
	//2.생성자
	//ctrl+스페이스바
	public BoardDto() {}

	public BoardDto(String writer, String content, int view) {
		super();
		this.writer = writer;
		this.content = content;
		this.view = view;
	}
	// 3. (선택) 게시물 등록시 사용되는 함수

	public BoardDto(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}

	//3.메소드
		//1. (권장) setter and getter : 외부로부터 필드 값이 호출불가능 하기 때문에
	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	//2. (권장) to String  
	public String toString() {
		return "BoardDto [writer=" + writer + ", content=" + content + ", view=" + view + "]";
	}
}

/*
 
 DTO: 이동 객체
 	1.객체에 저장할 필드 선정
 		1.private 으로 필드 선언[권장] : 객체내 필드 직접적인x
 		2.타입
 		3.필드명
 	2.생성자
 		1.빈생성자
 		2.풀생성자
 		3.그외 생성자 [ex)등록할때 사용하는 생성자]
 	3.메소드
 		1.setter and getter : 필드가 직접적인[private]접근 불가능하기 때문에 메소드를 이용한 필드 간접접근
 			set 필드명() : 필드에 값 대입할때 사용되는 메소드
 			get 필드명() : 필드에 값 호출할때 사용되는 메소드
 		2.toString() 	:   객체호출시 주소값이 반환되지만 객체내 필드값을 반환하고 싶을때 사용되는 메소드
 
 */