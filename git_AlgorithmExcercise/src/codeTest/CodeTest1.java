package codeTest;

public class CodeTest1 {

	public static void main(String[] args) {
		System.out.println("피보나치 수열 시작");
		
		for(int i=0; i<10; i++) {
//			System.out.println(fibonachi(i));
		}
		System.out.println(fibonachi(10));
	}
	
	private static int fibonachi(int cnt) {
		
		if(cnt <= 0) return 0;
		if(cnt == 1) return 1;
	
		return fibonachi(cnt-2)+fibonachi(cnt-1);
	}
	
}
