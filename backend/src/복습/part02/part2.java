package 복습.part02;

import java.util.Arrays;
import java.util.Scanner;

public class part2 {//class s
	
	public static void main(String[] args) {//main s
		
		
		String 재고관리 ="10,0,300\n 3,0,200\n 2,0,100\n";
		Scanner scanner=new Scanner(System.in);
		System.out.println(재고관리);
		
		
		while(true) {//while s
			
			System.out.println("\n\n-----------------------메뉴-----------------");
			System.out.println("1. 콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.println(">>>>>>>>선택"); int ch=scanner.nextInt();
			
			
			
			String 콜라정보=재고관리.split("\n")[0];
			String 환타정보=재고관리.split("\n")[1];
			String 사이다정보=재고관리.split("\n")[2];
			
			int 콜라재고=Integer.parseInt(콜라정보.split(",")[0]) ;
	
			int 콜라바구니=Integer.parseInt(콜라정보.split(",")[1]) ;
			
			int 콜라가격=Integer.parseInt(콜라정보.split(",")[2]) ;
			
			int 환타재고=Integer.parseInt(환타정보.split(",")[0]) ;
			int 환타바구니=Integer.parseInt(환타정보.split(",")[0]) ;
			int 환타가격=Integer.parseInt(환타정보.split(",")[0]) ;
			
			int 사이다재고=Integer.parseInt(사이다정보.split(",")[0]) ;
			int 사이다바구니=Integer.parseInt(사이다정보.split(",")[0]) ;
			int 사이다가격=Integer.parseInt(사이다정보.split(",")[0]) ;
			
			if(ch==1) {
				if(콜라재고>0) {콜라재고--; 콜라바구니++;System.out.println("안내) 콜라 담았습니다");}
			else {System.out.println("안내) 콜라 재고가없습니다. [관리자 문의]");}
				}
			else if(ch==2) {
				if(사이다재고>0) {사이다재고--;사이다바구니++;System.out.println("안내) 사이다 담았습니다.");}
				else {System.out.println("안내) 사이다 재고가없습니다. [관리자 문의]");}
			}
			else if(ch==3) {
				if(환타재고>0) {환타재고--;환타바구니++; System.out.println("안내) 환타 담았습니다.");}
				else {System.out.println("안내) 환타 재고가없습니다. [관리자문의]");}
			}
			else if(ch==4) {
				System.out.println("--------------------------------");
				System.out.printf("%3s %2s %2s","제품명","수량","가격");
				System.out.println("1.결제 2.취소"); int ch2=scanner.nextInt();
				if(콜라바구니>0) {System.out.printf("%3s %2d %5d\n","콜라",콜라바구니,콜라바구니*콜라가격);}
				if(사이다바구니>0) {System.out.printf("%3s %2d %5d\n","사이다",사이다바구니,사이다바구니*사이다가격);}
				if(환타바구니>0) {System.out.printf("%3s %2d %5d\n","환타",환타바구니,환타바구니*환타가격);}
				int 총가격 = (콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격);
				if(ch2==1) {
					System.out.println("안내 금액 투여 :" ); int pay=scanner.nextInt();
					if(pay>=총가격) {System.out.println("잔액:"+(총가격-pay));
					콜라바구니=0; 사이다바구니=0;환타바구니=0;
					System.out.println("주문번호 : 1");
					}
					else {콜라재고+=콜라바구니 ; 사이다재고+=사이다바구니; 환타재고+=환타바구니; 
						
						System.out.println("안내) 금액이 부족합니다. 초기화면으로 돌아갑니다.");
					}
				}
				else if(ch2==2) {
					콜라재고+=콜라바구니; 사이다재고+=사이다바구니; 환타재고+=환타바구니;
					콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					System.out.println("안내) 장바구니를 초기화합니다.");
				}
			}
			재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"
					+ 환타재고+","+환타바구니+","+환타가격+"\n"
					+ 사이다재고+","+사이다바구니+","+사이다가격+"\n";
			
			
			
		}//while e
		
		
	}//main e
}//class e
