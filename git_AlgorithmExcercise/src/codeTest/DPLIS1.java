package codeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import file.FileIO;

public class DPLIS1 {

	public static void main(String[] args) {
		FileIO.logFileCreate(true, false);
		System.out.println("합친 증가 부분수열 동적 계획 start...");
		
		System.out.print("Input Case : ");
		Scanner sc = new Scanner(System.in);
		int caseCnt = sc.nextInt();
		sc.nextLine();
		System.out.println("Case 수 확인 : " + caseCnt);
		
		
		Map<String, String> hm = new HashMap<String,String>();
		List<Integer> strList = new ArrayList<Integer>();
		
		while (caseCnt > 0) {
			hm.clear();
			
			System.out.print("Input aBLength : ");
			String aBLength = sc.nextLine();
			System.out.println("lengt A : " + aBLength.split(" ")[0] + "\t length B : "+ aBLength.split(" ")[1]);
			
			System.out.print("Input atomA : ");
			String atomA = sc.nextLine();
			System.out.println("atom A = " + atomA);
			
			for(String tmp : atomA.split(" ")) {
				hm.put(tmp, tmp);
			}
			

			System.out.print("Input atomB : ");
			String atomB = sc.nextLine();
			System.out.println("atom B = " + atomB);
			for(String tmp : atomB.split(" ")) {
				hm.put(tmp, tmp);
			}

			System.out.println("hm = " + hm);

			strList.add(hm.size());
			
			--caseCnt;
		}
		
		for(int tmp : strList) {
			System.out.println(tmp);
		}
		
		System.out.println("system Finish...");
		
	}
	
	public static int lisResult() {
		
		return 0;
	}

}
