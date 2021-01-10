package codeTest;

import file.FileIO;
import time.PrintExecTime;

/*
 * 외발 뛰기(JumpGame)
 * 알고리즘 문제해결전략
 * 배열 게임판의 숫자는 1~9까지의 숫자
 */
public class DPOneLegJumping {
	
	static int callCnt = 0;
	static int[][] visitArr = new int[100][100];
	
	public static void main(String[] args) {
		
		int[][] arr = { {2,5,1,6,1,4,1},{6,1,1,2,2,9,3},{7,2,3,2,1,3,1},{1,1,3,1,7,1,2},{4,1,2,3,4,1,2},{3,3,1,2,3,4,1},{1,5,2,9,4,7,0} };
		
		FileIO createLog = new FileIO();
		createLog.logFileCreate(true, false);
		
		printArray(arr);
		System.out.println("\n실행시간 측정...");
		
		PrintExecTime printExecTime = new PrintExecTime();
		long startTime = printExecTime.printStartTime();
		System.out.println(startTime);
		
		int tmp = jumping(arr, 0, 0);
		
		long finishTime = printExecTime.printFinishTime();
		System.out.println(finishTime);
		System.out.println("Total Exec Time : " + (finishTime - startTime));
		
		System.out.println("외발뛰기 끝점까지 갈 수 있는지 검색 확인 : " + tmp);
		System.out.println("How many call method : " + callCnt);
	}

//	public static int jumping(int[][] arr, int x, int y){
//
//		callCnt++;
//		System.out.print("["+x+", "+y+"] -> ");
//		// 배열의 범위를 벗어난 x,y 값인지 체크
//		if( x > (arr.length-1) || y > (arr.length-1)) {
//			System.out.print("over -> ");
//			return -1;
//		}
//		
//		if( x==(arr.length-1) && y==(arr.length-1) ) {
//			System.out.println("Find");
//			return 1;
//		}
//		
//		if( jumping(arr, x+arr[x][y], y) < 0) {
//			if(jumping(arr, x, y+arr[x][y]) < 0) return -1;
//			else return 1;
//		} else {
//			return 1;
//		}
//	}

	public static int jumping(int[][] arr, int x, int y){
		
		callCnt++;
		System.out.print("["+x+", "+y+"] -> ");
		// 배열의 범위를 벗어난 x,y 값인지 체크
		if( x > (arr.length-1) || y > (arr.length-1)) {
			System.out.print("over -> ");
			return -1;
		}
		
		if( x==(arr.length-1) && y==(arr.length-1) ) {
			System.out.println("Find");
			return 1;
		}
		
		if( visitArr[x][y] != 0) {
			System.out.println("이미 저장된 값! x="+x+"  y="+y);
			return visitArr[x][y];
		}
		
		int find = jumping(arr, x+arr[x][y], y);
		if( find < 0) {
			visitArr[x+arr[x][y]][y] = find;
			int find2 = jumping(arr, x, y+arr[x][y]);
			if( find2 < 0) {
				visitArr[x][y+arr[x][y]] = find2;
				return -1;
			}
			else return 1;
		} else {
			return 1;
		}
	}
	
	public static void printArray(int[][] arr) {
		System.out.println("");
		System.out.println("--------------------------------------");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}
}
