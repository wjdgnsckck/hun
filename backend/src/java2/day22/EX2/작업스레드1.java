package java2.day22.EX2;

public class 작업스레드1 implements Runnable {
	@Override
	public void run() {
		try {
			int count = 1;
			while(true) {Thread.sleep(5000);	//1초간 일시정지 [예외처리필수]
				Thread.currentThread().setName("스레드1");
				System.out.println(Thread.currentThread().getName()+ "[main Therad] output :" + count);
			
			count ++;
		
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
