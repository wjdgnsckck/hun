package java2.day23.Ex2;

public class WorkThread extends Thread {
	
	//필드
	public boolean work =true; 
	// : 스레드 상태의 사영되는 스위치변수[on/off]
	//생성자
	public WorkThread(String name) {
		setName(name); // 스레드의 이름 변경
		//Thread.currentThread().setName()
	}
	//메소드
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName());
				//Thread.currentThread().getName()
			}
			else{
				Thread.yield();
			}
		}// 해당 스레드는 무한루프 [ 절대 종료되니 않는 스레드 ]
	}
}
