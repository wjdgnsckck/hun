package java2.day22.EX2;

public class 작업스레드2 extends Thread{
	@Override
	public void run() {
		try {
			int count = 1;
			while(true) {	Thread.sleep(10000);	//1초간 일시정지 [예외처리필수]
			Thread.currentThread().setName("스레드2");
				System.out.println(Thread.currentThread().getName()+ "[main Therad] output :" + count);
		
			count ++;
		
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
