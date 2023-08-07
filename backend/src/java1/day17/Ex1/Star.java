package java1.day17.Ex1;

public class Star {

	 public static void main(String[] args) {
	        int n = 7;  // 자동차 높이 설정

	        // 윗부분 그리기
	        for (int i = 0; i < n - 2; i++) {
	            for (int j = 0; j < n - i - 2; j++) {
	                System.out.print(" ");
	            }
	            System.out.print("*");

	            if (i > 0) {
	                for (int j = 0; j < i * 2; j++) {
	                    System.out.print(" ");
	                }
	                System.out.print("*");
	            }

	            System.out.println();
	        }

	        // 중간부분 그리기
	        for (int i = 0; i < n * 2; i++) {
	            System.out.print("*");
	        }
	        System.out.println();

	        // 아랫부분 그리기
	        for (int i = 0; i < n - 2; i++) {
	            System.out.print("*");

	            for (int j = 0; j < n * 2 - 3; j++) {
	                System.out.print(" ");
	            }

	            System.out.println("*");
	        }

	        // 바퀴 그리기
	        for (int i = 0; i < n * 2 - 1; i++) {
	            System.out.print(" ");
	        }
	        System.out.println("*");

	        for (int i = 0; i < n * 2 - 1; i++) {
	            System.out.print(" ");
	        }
	        System.out.println("*");
	    }
}

