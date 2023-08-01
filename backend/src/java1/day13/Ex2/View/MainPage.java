package java1.day13.Ex2.View;

import java.util.Scanner;

import java1.day13.Ex2.Controller.BoardController;
import java1.day13.Ex2.Model.Dao.BoardDao;
import java1.day13.Ex2.Model.Dto.BoardDto;

public class MainPage {
	
	
	
	
	//싱글톤(공유) O:게시물마다 가 아닌 모든 게시물이 동일한 기능 수행
	
	//1. 현재클래스안에 현재클래스로 객체 선언[private static]
	private static MainPage mainPage =new MainPage();
	//2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수
	public static MainPage getInstance() {return mainPage;}
	//3. **외부로부터 객체 생성 차단
	private MainPage() {}
	//---------------------------------------------//
	
	//입력객체 필드
	private Scanner sc =new Scanner(System.in);
	
	//메인페이지 입출력 함수
	
	public void mainPage() {
		
		while(true) {
		
			 System.out.println("\n\n>>>>>>>방문록 프로그램>>>>>>>");
			 System.out.println("1.글등록 2.글보기 3.글수정 4.글삭제 선택>");
			 int ch=sc.nextInt();
			 if(ch==1) {writeView();}// 각 번호별 페이지 함수 호출
			 if(ch==2) {printeView();}
			 if(ch==3) {updateView();}
			 if(ch==4) {deleteView();}
		
		}
	}
	
	//글등록 페이지 입출력 함수
	public void writeView() {
		//1. 내용(띄어쓰기)과 작성자(띄어쓰기x)을 입력받아 변수 저장
		sc.nextLine();		//**next Line () 함수 실행전 nextInt()실행되므로 오류방지
		System.out.println("방문록 : ");String content=sc.nextLine();
		System.out.println("작성자 : ");String writer=sc.next();
		
		//2.입력받은 변수 컨트롤에 전송하기
		//현재위치도 Java 컨트롤도 java이므로 메소드 이용한다.
		//전달보내기 = 매개변수 / 전달받기 = 리턴
		
		//View 에서 controller 함수 호출하기
		boolean result=BoardController.getInstance().writeLogic(writer,content);
		if(result) System.out.println("글 등록했습니다.");
		else {System.out.println("글 등록실패");}

		
	}
		
	//글출력 페이지 입출력 함수
	public void printeView() {
		//1. 보고자하는 게시물의 인덱스 입력받아서 저장
		System.out.println("출력할 방문록의 인덱스:");int index=sc.nextInt();
		
		//2. view에서 컨트롤에게 입력받은 인덱스 전달보내고 선택한 인덱스의 게시물1개 리턴 받음
		

	BoardDto result= BoardController.getInstance().printLogic(index);
	System.out.println("안내]검색한 방문록 정보");
	System.out.println("작성자 : "+result.getWriter()+"\n"+
						"내용 : "+result.getContent()+"\n"+
						"조회수:"+result.getView());
	
	}	
		
	
	//글수정 페이지 입출력 함수
	public void updateView() {
		System.out.println("안내] 수정할 게시물의 인덱스:"); int index=sc.nextInt();
		sc.nextLine();
		System.out.println("안내] 수정할 내용");			String content=sc.nextLine();
		System.out.println("안내] 수정할 작성자");		String writer=sc.next();
		boolean result= BoardController.getInstance().updateLogic(index,content,writer);
		if(result) {
			System.out.println("안내]수정완료됬습니다.");
			
		}
		else {System.out.println("안내]수정 실패");}
	}
	
	//글삭제 페이지 입출력 함수
	public void deleteView() {
		System.out.println("안내]삭제할 방문록의 인덱스"); int index=sc.nextInt();
		//view 에서 컨트롤러에게 index보내고 boolean 으로 true false 받기
		boolean result=BoardController.getInstance().deleteLogic(index);
		if(result) {System.out.println("안내] 글 삭제 완료했습니다.");}
		else {System.out.println("안내] 없는 글 입니다.");}
		System.out.println(BoardDao.getInstance());
	}
		
	
	//글수정 페이지 입출력 함수

}
