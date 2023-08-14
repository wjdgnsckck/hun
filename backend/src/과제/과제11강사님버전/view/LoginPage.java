package 과제.과제11강사님버전.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import 과제.과제11강사님버전.controller.BoardController;
import 과제.과제11강사님버전.controller.MemberController;
import 과제.과제11강사님버전.model.dto.BoardDto;
import 과제.과제11강사님버전.model.dto.MemberDto;
import 과제.과제11강사님버전.model.dto.MessageDto;

// 로그인이 완료된 이후의 화면
public class LoginPage {
	
	// 0 싱글톤
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() {
		return loginPage;
	}
	private LoginPage() {}
	
	// 0 입력객체
	Scanner sc = new Scanner(System.in);
	
	// 1 loginMenu		로그인했을 때 메뉴 페이지
	public void loginMenu() {
		boardPrint() ;
		while(MemberController.getInstance().getLoginSession() != 0) {
			System.out.println("\n\n======= 회원제 커뮤니티 =======");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기  4. 글조회 선택");
			
			try {
				
				int ch = sc.nextInt();
				// 만약에 타입과 일치하지 않는 값을 입력하면 
				// java.util.InputMismatchException 발생
				
				if(ch==1) MemberController.getInstance().logOut();
				
				if(ch==2) info();
				
				if(ch==3) boardWrite();
				
				if(ch==4) boardView();
			} catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다");
				sc =  new Scanner(System.in);
				// 입력객체의 메모리를 새롭게 만들어줘야함
			}
		}
		
		
		
	}
	// 2 info			회원정보 페이지
	public void info() {
		System.out.println("\n\n=====info=====");
		//1. 컨트롤에게 회원정보[DTO] 요청해서 1명의 회원정보[DTO] 반환 받기
		MemberDto result = MemberController.getInstance().info();
		//2. 반환받은 회원정보객체[memberDto] 의 각필드를 출력ㄴ
		System.out.println(">ID : "+result.getMid());
		System.out.println(">NAME : "+result.getMname());
		System.out.println(">PHONE : "+result.getMphone());
		//controller -> 
		
		//2. 서브메뉴
		System.out.println("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 4.쪽지확인  선택 :");
		int ch =sc.nextInt();
		if(ch==1) {infoUpdate();}
		if(ch==2) {infoDelete();}
		if(ch==3) {return;}
		if(ch==4) {checkMessage();};
		System.out.println();
		
	}
	// 3 infoUpdate		회원수정 페이지
	public void infoUpdate() {
		System.out.println("\n\n====password Update===");
		System.out.println("새로운 비밀번호 :" ); String newPw=sc.next();
		boolean result =
		MemberController.getInstance().infoUpdate(newPw);
		if(result) {System.out.println("비밀번호 수정완료:로그아웃됩니다.");
						MemberController.getInstance().logOut();
		}
		else {System.out.println("비밀번호수정실패:관리자에게문의");}
		
	}
	// 4 infoDelete		회원탈퇴 페이지
	public void infoDelete() {
		System.out.println("\n\n====member delete===");
		System.out.println("정말 탈퇴하시겠습니까?? 1.예 2.아니요 :");int ch = sc.nextInt();
		if(ch==1) {
		Boolean result=	MemberController.getInstance().infoDelete();
			if(result) {System.out.println("회원탈퇴성공 : 로그아웃됩니다.");
			 MemberController.getInstance().logOut();
			}else {System.out.println("회원탈퇴실패: 관리자에게 문의");}
		}
	}
	// 5 boardWrite		게시물쓰기 페이지
	public void boardWrite() {
		System.out.println("\n\n==========board write==========");
		System.out.println("제목 :"); String title =sc.next();
		System.out.println("내용 :"); String content =sc.next();
		boolean result= BoardController.getInstanct().boardWrite(title,content);
		if(result) {System.out.println("안내] 글쓰기 등록");}
		else {System.out.println("안내] 글쓰기 실패 : 제목 1~50 필수 입력");}
	}
	// 10 boardPrint		모든 게시물 출력
	public void boardPrint() {
		System.out.println("\n\n==========post List==========");
		ArrayList<BoardDto>result = BoardController.getInstanct().boardPrint();
		//2. 출력
		System.out.printf("%-3s %-4s %-19s %-10s %s \n", "no" , "view" , "date", "mid", "title");
		for(int i = 0 ; i<result.size(); i++) {
						//리스트.size() : 리스트내 객체수 => length 동일
			BoardDto dto =result.get(i);
			System.out.printf("%-3s %-4s %-19s %-10s %s \n", dto.getBno() ,dto.getBview() ,dto.getBdate(), dto.getMid(),
					dto.getBtitle());
		}
	}
	// 11 boardView		개별 게시물 출력
	public void boardView() {
		System.out.println("\n\n==========board VIEW==========");
		//1. 보고자하는 게시물의 게시물번호를 입력받기 [ 식별번호 ]
		System.out.println("게시물번호 :"); int bno=sc.nextInt();
		//2. 전달하기
		BoardDto result = BoardController.getInstanct().boardView(bno);
		//3. 출력
		System.out.printf("bno : %3s view :%3s mid : %10s date : %19s  \n",
		result.getBno(),result.getBview(),result.getMid(),result.getBdate());
		System.out.printf("title : %s\n",result.getBtitle());
		System.out.printf("content : %s\n" ,result.getBcontent());
		//4. 추가메뉴
		System.out.println("1.뒤로가기 2.수정 3.삭제 4.쪽지보내기 선택>"); int ch =sc.nextInt();
		if(ch==1) {return;}
		if(ch==2) {boardUpdate(bno,result.getMno()) ; boardPrint() ; }
		if(ch==3) {boardDelete(bno,result.getMno()) ; boardPrint() ; }
		if(ch==4) {sentMessage();}
		
	}
	// 12 boardUpdate	게시물 수정[ 게시물번호 식별해서 제목이랑 내용만 수정 - > 로그인된 사람
	public void boardUpdate(int bno , int mno) {
		System.out.println("\n\n==========post update==========");
		sc.nextLine();
		System.out.println("수정할 제목 :"); String title =sc.next();
		System.out.println("수정할 내용 :"); String content =sc.next();
		//2.
		int result=
		BoardController.getInstanct().boardUpdate( bno,mno,title,content);
		if(result==1) {System.out.println("안내] 수정이 완료되었습니다.");}
		if(result==2) {System.out.println("안내] 글 수정 실패 : 관리자 오류");}
		if(result==3) {System.out.println("경고] 본인 글만 수정 가능합니다. ");}	
		if(result==4) {System.out.println("경고] 수정할 제목을 1~50글자 사이로 입력해주세요.");}
			}
			
		
	
	// 13 boardDelete	게시물 삭제
	public void boardDelete(int bno , int mno) {
		int result=BoardController.getInstanct().boardDelete(bno,mno);
		if(result==1) {System.out.println("안내] 수정이 완료되었습니다.");}
		else if(result==2) {System.out.println("안내] 글 삭제 실패 : 관리자 오류");}
		else if(result==3) {System.out.println("경고] 본인 글만 삭제 가능 합니다.");}
	}
	
	//14.쪽지보내기 
	public void sentMessage() {
		System.out.println("=========쪽지보내기========");
		System.out.println("보낼 쪽지 내용 :"); String content =sc.next();
		boolean result= BoardController.getInstanct().sentMessage(content);
		if(result)System.out.println("쪽지 보내기 완료!"); 
		else System.out.println("안내]쪽지 보내기 실패");
		
	} 
	//15. 쪽지확인 페이지 // + 쪽지답장 보내기
	public void checkMessage() {
		System.out.println("=========쪽지확인=======");
		ArrayList<MessageDto>result = BoardController.getInstanct().checkMessage();
		//2. 출력
		System.out.printf("%-3s %-4s %-25s %-25s %s\n", "pno" , "mno","pcontent" , "pdate", "mid");
		for(int i = 0 ; i<result.size(); i++) {
						//리스트.size() : 리스트내 객체수 => length 동일
			MessageDto dto =result.get(i);
			System.out.printf("%-3s %-4s %-20s %-20s %s\n", dto.getPno() , dto.getMno(),dto.getPcontent() ,dto.getPdate(), dto.getMid());
			reply(dto.getPno()); 
	}
		
	}
	//16. 쪽지답장 보내기 페이지
	public void reply(int pno) {
		System.out.println("======답장 보내기 ========");
		System.out.println("답장 보낼 쪽지 번호를 입력해주세요 선택:"); int ch=sc.nextInt();
		
		if(pno==ch) {System.out.println("답장 입력 : ") ;String reply= sc.next();
			boolean result =BoardController.getInstanct().reply(ch,reply);
			if(result)System.out.println("답장완료했습니다."); 
			else System.out.println("안내]입력오류");
		}
		else {System.out.println("안내]입력오류 초기화면으로 돌아갑니다.");}
		
	
		
	}
	
	
	
}//p end