package 복습.part04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class part4 {
	public static void main(String[] args) throws IOException {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String filePath="./src/복습/part04/재고파일.txt";
			FileOutputStream fileOutputStream=new FileOutputStream(filePath,true);//메모장에 보내기
			FileInputStream fileInputStream = new FileInputStream(filePath);//읽기위해 꺼내오기
			File file= new File(filePath);
			
			byte[] inByteArray= new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] 재고관리=fileInfo.split("z");
			
			System.out.println("\n\n-----------------메뉴------------------");
			System.out.println("-1:제품등록 0:결제");
			
			for(int i = 0 ; i<재고관리.length ; i++) {
				if(!재고관리[i].equals("")) {
					String name = 재고관리[i].split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					if(stock==0) {System.out.println( (i+1)+":"+name+"[재고없습니다]");}
					else {System.out.println( (i+1)+":"+name+"["+price+"]");}
					
				}
				
			}//for end
			System.out.println("\n>>>>>>>>> 선택 :"); int ch=scanner.nextInt();
			
			/*--------제품 등록-------------*/
			if(ch==-1) {
				System.out.println("제품명 : "); String name=scanner.next();
				System.out.println("초기재고 :"); int stock =scanner.nextInt();
				System.out.println("가격 :");		int price =scanner.nextInt();
												int basket=0;
				
				String outStr = name+","+stock +","+price +","+basket;	//객체화 해주기
				fileOutputStream.write(outStr.getBytes());
				System.out.println("안내) 제품 등록이 되었습니다.");
				
			}
			else if(ch>0&&ch<=재고관리.length) {
				String name = 재고관리[ch-1].split(",")[0];
				int stock=Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price=Integer.parseInt(재고관리[ch-1].split(",")[2]);
				int basket=Integer.parseInt(재고관리[ch-1].split(",")[3]);
				
				if(stock>0) {stock--; basket++; System.out.println(name+"제품을 담았습니다.");}
				else {System.out.println(name+"제품의 재고가 부족합니다.");}
				//최신화
				재고관리[ch-1]=name+","+stock+","+basket+","+price;
				String outStr="";
				for(int i = 0 ; i<재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+","+
				재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n";
					
				}//for end
				FileOutputStream fileOutputStream2 =new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				
				
			}
			else if(ch==0) {
				System.out.printf("%10s %10s %10s \n","제품명","수량","가격");
				for(int i = 0 ; i<재고관리.length; i++) {
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[1];
					if(basket>0) {
						System.out.printf("%10s %10s %10s \n",name,basket,basket*price);
					}
				}
			}
		}
	}
}
