package codeTest;

import java.util.HashMap;

import file.FileIO;

/**
 * 
 * 삼각형으로 배치된 자연수들이 있다. 맨 위의 숫자에서 시작해서 한 번에 한 칸씩 아래로 내려갈 때마다
 * 바로 아래 숫자, 혹은 오른쪽 아래 숫자로만 내려갈 수 있다. 이 때 모든 경로 중숫자의 합을 최대화 하는 경로는 무엇?
 * @author dongki
 *
 */

public class DPTriangleMaxRoot {

	static int[][] trMap = { {6,0,0,0,0}
							,{1,2,0,0,0}
							,{3,7,4,0,0}
							,{9,4,1,7,0}
							,{2,7,5,9,4}};
	static HashMap<Integer, Integer> pq= new HashMap <Integer, Integer>() ;
	static int iCnt = 0;
//		int[][] trMap = {{1,0,0,0,0},{2,4,0,0,0},{8,16,8,0,0},{32,64,32,64,0},{128,256,128,256,128}};
	
	public static void main(String[] args) {
		System.out.println();
		FileIO.logFileCreate(true, false);
		maxRoot(0,0, 0);
		System.out.println(pq);
		
		System.out.println("\niCnt = " + iCnt);
	}
	
	//완전탐색법 
	public static boolean maxRoot(int x, int y, int sum) {
		System.out.println("x = " + x + "  y = " + y + "  sum = " + sum + " trMap[x][y] = " + trMap[x][y] );

		if( x >= trMap.length || y >= trMap.length) {
			System.out.println("검증");
			return false;
		}
		if( trMap[x][y] > 0 ) {
			System.out.println("더해지는 값 : " + trMap[x][y]);
			sum = sum+trMap[x][y];
		}
		
		iCnt++;
		
		if( x+1 <= trMap.length-1 ) {
			if( maxRoot(x+1, y, sum) ) {
				if( maxRoot(x+1, y+1, sum)) {
					return true;
				}
			}
		}
		
		pq.put(sum, sum);
		System.out.println("\t\t\t끝지점 도달( "+(sum)+" )" + "\t\t x = " + x + " y = " + y);
		return true;
	}

//	//메모이제이션 
//	public static int maxSum(int x, int y) {
//		System.out.println("x = " + x + "  y = " + y );
//		
//		if( x >= trMap.length || y >= trMap.length) {
//			System.out.println("검증");
//			return -1;
//		}
//		if( trMap[x][y] > 0 ) {
//			System.out.println("더해지는 값 : " + trMap[x][y]);
////			sum = sum+trMap[x][y];
//		}
//		
//		iCnt++;
//		
//		if( x+1 <= trMap.length-1 ) {
//			if( maxRoot(x+1, y) ) {
//				if( maxRoot(x+1, y+1)) {
//					return true;
//				}
//			}
//		}
//		
////		pq.put(sum, sum);
//		return true;
//	}

}
