package 복습.part02;

import java.util.Scanner;

public class part2EX3 {

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			String 재고관리="3,0,300\n2,0,200\n1,0,100\n";
			
			while(true) {
				String 콜라현황=재고관리.split("\n")[0];
				String 환타현황=재고관리.split("\n")[0];
				String 사이다현황=재고관리.split("\n")[0];
				
				int 콜라재고=Integer.parseInt(콜라현황.split(",")[0]);
				int 콜라바구니=Integer.parseInt(콜라현황.split(",")[1]);
				int 콜라가격=Integer.parseInt(콜라현황.split(",")[2]);
				
				int 환타재고=Integer.parseInt(환타현황.split(",")[0]);
				int 환타바구니=Integer.parseInt(환타현황.split(",")[1]);
				int 환타가격=Integer.parseInt(환타현황.split(",")[2]);
				
				int 사이다재고=Integer.parseInt(사이다현황.split(",")[0]);
				int 사이다바구니=Integer.parseInt(사이다현황.split(",")[1]);
				int 사이다가격=Integer.parseInt(사이다현황.split(",")[2]);
				
				System.out.println("--------------메뉴-----------------");
				System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4. 결제");
				System.out.println(">>>>>>>> 선택:"); int ch = sc.nextInt();
				if(ch==1) {
					if(콜라재고>0) {콜라재고--; 콜라바구니++; System.out.println("안내) 콜라 담았습니다.");}
					else {System.out.println("안내) 콜라 재고가없습니다.");}
				}
				else if(ch==2) {
					if(환타재고>0) {환타재고--; 환타바구니++; System.out.println("안내) 환타 담았습니다.");}
					else {System.out.println("안내) 환타 재고가없습니다.");}
				}
				else if(ch==3) {
					if(사이다재고>0) {사이다재고--; 사이다바구니++; System.out.println("안내) 사이다 담았습니다.");}
					else {System.out.println("안내) 사이다 재고가없습니다.");}
				}
				else if(ch==4) {
					System.out.println("--------------------------------------------");
					System.out.printf("%3s %2s %2s","제품명","수량","가격");
					
				}
			
				
				
			}
		}
}
