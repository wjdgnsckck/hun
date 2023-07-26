package 복습.part01;

import java.util.Scanner;

public class part2 {

	public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
		   int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		    while(true) {
		    	System.out.println("---------------메뉴----------------");
		    	System.out.println("1.콜라[300]2.환타[200]3.사이다[100]4.결제");
		    	System.out.println(">>>>>>>>>>선택:");int ch=scanner.nextInt();
		    	if(ch==1) {
		    		if(콜라재고>0) {콜라재고--;콜라바구니++;
		    		System.out.println("안내) 콜라 담았습니다.");}
		    		else {System.out.println("안내) 콜라 재고가없습니다.");}
		    	}
		    	else if(ch==2){
		    		if(환타재고>0) {환타재고--;환타바구니++;
		    		System.out.println("안내) 환타 담았습니다.");}
		    		else {System.out.println("안내) 환타 재고가없습니다.");}
		    	}
		    	else if(ch==3){
		    		if(사이다재고>0) {사이다재고--; 사이다바구니++;
		    		System.out.println("안내)사이다 담았습니다.");}
		    		else {System.out.println("사이다 재고가없습니다.");}
		    	}
		    	else if(ch==4){
		    		System.out.println("-------------------------");
		    		System.out.printf("%3s %2s %2s\n","제품명","수량","가격");
		    		if(콜라바구니>0) {System.out.printf("%3s %2d %5d\n","콜라",콜라바구니,콜라가격*콜라바구니);}
		    		if(사이다바구니>0) {System.out.printf("%3s %2d %5d\n","사이다",사이다바구니,사이다가격*사이다바구니);}
		    		if(환타바구니>0) {System.out.printf("%3s %2d %5d\n","환타",환타바구니,환타가격*환타바구니);}
		    		int 총가격 = 콜라바구니*콜라가격+사이다바구니*사이다가격+환타바구니*환타가격;
		    		System.out.println("총가격 :"+총가격);
		    		System.out.println("-----------------------");
		    		System.out.println("1.결제 2.취소");int ch2=scanner.nextInt();
		    		if(ch2==1) {
		    			System.out.println("안내 금액 투여:");int pay=scanner.nextInt();
		    			if(pay>=총가격) {
		    				System.out.println("잔액 : "+(pay-총가격));
		    				콜라바구니=0; 환타바구니=0; 사이다바구니=0;
		    			}
		    			else {
		    				System.out.println("안내)금액부족 초기화면으로 돌아갑니다.");
		    				콜라재고+=콜라바구니 ; 사이다재고+=사이다바구니; 환타재고+=환타바구니;
		    			}
		    		}
		    		else {System.out.println("안내)취소 초기화면으로 돌아갑니다.");
		    		콜라재고+=콜라바구니 ; 사이다재고+=사이다바구니; 환타재고+=환타바구니;}
		    		 
		    	}
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    }
	}
}
