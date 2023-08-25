
package java2.day26_컬랙션프레임워크.Ex2.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import java2.day26_컬랙션프레임워크.Board;

public class Ex_2예제 {

	public static void main(String[] args) {
		// 1. Vector 리스트 객체 생성
		// ArrayList vs Vector
		// 내부구조 동일하고 함수도 동일
		// 동기화 x vs 동기화 o
		//List<Board> list = new Vector<>();	//동기화 가능!! 동기화 : 순서를 매겨서 순서에 맞게 실행하는것
		 List<Board> list =new ArrayList<>();	//동기화 불가능!! add사용시 바꿔치기 당한다

		// 2. 작업 스레드 추가A
		// Thread threadA = new Thread(){};
		Thread threadA = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					list.add(new Board("제목", "내용", "글쓴이"));
				}
			}

		};
		// 2. 작업 스레드 추가B
		// Thread threadB = new Thread(){};
		Thread threadB = new Thread() {

			@Override
			public void run() {for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목", "내용", "글쓴이"));
				}
			}

		};
		//3. 스레드 실행
		threadA.start();
		threadB.start();
		
		//4. main 대기상태 만들기. [ 두 스레드의 작업이 모두 끝날때까지 main스레드는 대기해라 => 작업결과를 확인하기 위해 ]
		try{threadA.join(); threadB.join();}catch (Exception e) {}
		//5.
		System.out.println("두 스레드가 추가한 리스트의 객체수 : "+list.size());
		
	}

}// C end
