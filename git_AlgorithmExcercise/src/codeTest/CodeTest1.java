package codeTest;

import java.io.File;
import java.io.IOException;

public class CodeTest1 {
	static int callCnt = 0;
	static int[] fiboArr;
	public static void main(String[] args) {
		System.out.println("피보나치 수열 시작");
		
		fiboArr = new int [100];
		for(int i=0; i<=15; i++) {
			System.out.println("fibo = "+fibonachi(i));
		}
		
//		File f = new File("NewFile.java");
//		System.out.println(f.exists());
//		System.out.println(f.isDirectory());
	}
	
	private static int fibonachi(int cnt) {
		callCnt++;
		System.out.println("call Cnt = " + callCnt);
		if(cnt <= 0) return 0;
		if(cnt == 1) return 1;
		if(fiboArr[cnt] != 0) return fiboArr[cnt];
		else return fiboArr[cnt] = fibonachi(cnt-2)+fibonachi(cnt-1); 

//		return fiboArr[cnt] = fibonachi(cnt-2)+fibonachi(cnt-1);
	}
	
}
