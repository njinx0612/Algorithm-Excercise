package codeTest;

/*
 * 외발 뛰기(JumpGame)
 * 알고리즘 문제해결전략
 */
public class DPOneLegJumping {

	public static void main(String[] args) {
		
		int[][] arr = { {2,5,1,6,1,4,1},{6,1,1,2,2,9,3},{7,2,3,2,1,3,1},{1,1,3,1,7,1,2},{4,1,2,3,4,1,2},{3,3,1,2,3,4,1},{1,5,2,9,4,7,0} };
		
		printArray(arr);
		
		int tmp = jumping(arr, 0, 0, 7);
		System.out.println("외발뛰기 끝점까지 갈 수 있는지 검색 확인 : " + tmp);
	}

	public static int jumping(int[][] arr, int x, int y, int matrix){

		System.out.print("["+x+", "+y+"] -> ");
		// 배열의 범위를 벗어난 x,y 값인지 체크
		if( x > (matrix-1) || y > (matrix-1)) {
			System.out.print("over -> ");
			return -1;
		}
		
		//시작점과 끝점이 아닌데 값이 0인 경우
		if( arr[x][y] == 0 && (x<(matrix-1) && (y<(matrix-1))) ) {
			System.out.print("value error -> ");
			return -1;
		}
		
		if( x==(matrix-1) && y==(matrix-1) ) {
			System.out.println("Find");
			return 1;
		}
		
//		System.out.println("--- x:"+x+" y:"+y+"  arr[x][y]:"+arr[x][y]);
		if( jumping(arr, x+arr[x][y], y, matrix) < 0) {
			if(jumping(arr, x, y+arr[x][y], matrix) < 0) return -1;
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
