package 과제.과제5;

import java.util.Scanner;
import java.util.Arrays;
public class 과제5_키오스크 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		
		// 1. 9개 변수가 가지고 있던 상태/값/데이터 한 변수에 저장
			//재고관리 = "101010000300200100";	// 재고~ 바구니~ 가격~
			//재고관리 = "100300100200100100";	// 콜라(재고바구니가격)환타(재고바구니가격)사이다(재고바구니가격)
		
		// 2. JSON , XML , CSV 등 : 데이터 형식 규정
			// JSON : { 재고 : 10 , 바구니 : 0 , 가격 : 300 }
			// CSV : 10,0,300
		
		// ----------------1. 임의의 구분에 따른 여러 데이터를 하나의 문자열로 저장 ----------------- //
		// 1. 필드/상태/속성 간의 구분 ',' 채택!!! 
			// 재고관리 = "10,0,300,10,0,200,10,0,100";
		// 2. 필드의 단위별 묶음 '\n' 채택!!!
		재고관리 = "3,0,300\n2,0,200\n1,0,100\n";
		System.out.println( 재고관리 );
		
		// ----------------2. 임의의 구분에 따른 하나의 데이터를 여러 데이터로 변환 ----------------- //
		// 3. 임으이의 구분(문자)를 기준으로 분리 : .split(분리기준문자) : 분리후 배열[인덱스] 반환
			// "10,0,300\n10,0,200\n10,0,100\n"  --> \n  --> 조각수 4조각 
				// 1조각 : 10,0,300		// 2조각 : 10,0,200  // 3조각 : 10,0,100  // 4조각 : 
				//		콜라정보				환타정보				사이다정보					
		System.out.println( Arrays.toString(  재고관리.split("\n") ) ); // [10,0,300, 10,0,200, 10,0,100]
		System.out.println( "1조각 : " +재고관리.split("\n")[0] );  // 10,0,300	// 콜라정보
		System.out.println( "2조각 : " +재고관리.split("\n")[1] );	// 10,0,200 // 환타정보 
		System.out.println( "3조각 : " +재고관리.split("\n")[2] );	// 10,0,100 // 사이다정보 

		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			String 콜라정보 = 재고관리.split("\n")[0];
				// 10,0,300  ->  ',' 분리 -> 3조각 
				// 1조각 : 10    2조각:  0     3조각 : 300
			String 환타정보 = 재고관리.split("\n")[1];
			String 사이다정보 = 재고관리.split("\n")[2];
			
			int 콜라재고 = Integer.parseInt( 콜라정보.split(",")[0] ); 
			int 콜라바구니 = Integer.parseInt( 콜라정보.split(",")[1] ); 	
			int 콜라가격 = Integer.parseInt( 콜라정보.split(",")[2] ) ;
			
			int 환타재고 = Integer.parseInt( 환타정보.split(",")[0] ); 
			int 환타바구니 = Integer.parseInt( 환타정보.split(",")[1] ); 	
			int 환타가격 = Integer.parseInt( 환타정보.split(",")[2] ) ;
			
			int 사이다재고 = Integer.parseInt( 사이다정보.split(",")[0] ); 
			int 사이다바구니 = Integer.parseInt( 사이다정보.split(",")[1] ); 	
			int 사이다가격 = Integer.parseInt( 사이다정보.split(",")[2] ) ;
			
			/* ------------- 구현 기능 들어가는 자리 ------------  */
				// 과제4_2 구현코드 복붙 
			/* ------------------------------------------ */
			// 제품 변화가 있을경우 while 밖에 있는 재고관리 변수(원본)에 업데이트 // 주의 : 띄어쓰기[공백] 없어야함!!!!
			재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"
					+ 환타재고+","+환타바구니+","+환타가격+"\n"
					+ 사이다재고+","+사이다바구니+","+사이다가격+"\n";
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







