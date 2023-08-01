package 복습.part03;

import java.util.Scanner;

public class part3Ex3 {
	public static void main(String[] args) {
			int pay=0;
		   String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		   Scanner sc=new Scanner(System.in);
		   while(true) {
			   System.out.println("----------------메뉴---------------");
			   System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			   System.out.println(">>>>>>선택:"); int ch=sc.nextInt();
			   if(ch==1||ch==2||ch==3) {
				   String product=재고관리[ch-1];
				   int stock =Integer.parseInt(product.split(",")[0]);
				   int basket =Integer.parseInt(product.split(",")[1]);
				   int price =Integer.parseInt(product.split(",")[2]);
				   String name=product.split(",")[3];
				   if(stock>0) {
					   stock--;basket++; pay+=price; System.out.println("안내)" +name+"담았습니다.");
				   }else {System.out.println("안내 ) 재고가없습니다 [ 관리자문의 ]");}
				   재고관리[ch-1]= stock+","+basket+","+price+","+name;
			   }
			   else if(ch==4) {
				   System.out.println("-------------------");
				   System.out.printf("%10s %10s %10s\n","제품명","수량","가격");
				  
				   for(int i =0 ; i<재고관리.length; i++) {
					   int basket=Integer.parseInt(재고관리[i].split(",")[1]);
					   int price=Integer.parseInt(재고관리[i].split(",")[2]);
					   String name=재고관리[i].split(",")[3];
					   if(basket>0) {System.out.printf("%10s %10s %10s\n",name,basket,basket*price);}
					  
				   }
				   System.out.println("총금액 : "+pay);
				   
			   }
			   
			
		   }
	}
}
