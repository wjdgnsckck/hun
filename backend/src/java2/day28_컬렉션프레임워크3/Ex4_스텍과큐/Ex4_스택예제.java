package java2.day28_컬렉션프레임워크3.Ex4_스텍과큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex4_스택예제 {
	public static void main(String[] args) {
		//1.stack 객체(동전케이스) 선언
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//2. 무작위로 동전 넣기
		coinBox.push(new Coin(100));	
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		System.out.println(" 스택 상태 :" + coinBox);
		
		//3.Stack 객체에서 동전(객체) 꺼내기
		coinBox.pop(); System.out.println(" 스택 상태 : " +coinBox); //후입선출이므로 나중에 들어온값이 먼저 삭제
		
		//-------------------------------------------//
		
		//1.Queue 구현체(동전케이스) 선언
		Queue<Coin> coinBox2 = new LinkedList<>();
		
		//2. 무작위로 동전 넣기
		coinBox2.offer(new Coin(100));	
		coinBox2.offer(new Coin(50));
		coinBox2.offer(new Coin(500));
		coinBox2.offer(new Coin(10));
		System.out.println(" 큐 상태 :" + coinBox2);
		//객체 꺼내기
		coinBox2.poll(); System.out.println("큐상태 :" + coinBox2); //선입선출이기 때문에 먼저들어온 값이 삭제
	
	
	
	}

	
}
