package 복습.part01;


import java.util.Scanner;

public class part1 {//class start

	
	
	public static void main(String[] args) {//main start
		 int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		    Scanner scanner = new Scanner(System.in);
		    while(true) {
		    	System.out.println("\n\n ------------------메뉴--------------------");
		    	System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4. 결제");
		    	System.out.println(">>>>>>>>>>선택:"); int ch=scanner.nextInt();
		    	
		    	
		    	if(ch==1) {
		    		if(콜라재고>0) {콜라재고--;콜라바구니++;
		    		System.out.println("안내) 콜라 담았습니다.");}
		    	else {System.out.println("콜라 재고가 없습니다.");};
		    	}
		    	else if(ch==2) {
		    		if(환타재고>0) {환타재고--;환타바구니++;
		    			System.out.println("안내) 환타 담았습니다.");}
		    		else {System.out.println("안내) 환타 재고가없습니다.");}
		    	}
		    	else if(ch==3) {
		    		if(사이다재고>0) {사이다재고--;사이다바구니++;
		    		System.out.println("안내) 사이다 담았습니다.");}
		    	else {System.out.println("안내) 사이다 재고가없습니다.");}
		      }
		    	else if(ch==4) {System.out.println("결제창");}
		    }
	}//main end
}//class end
