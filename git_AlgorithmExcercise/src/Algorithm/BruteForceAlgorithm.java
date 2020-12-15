package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 완전탐색 알고리즘
 * @author dongki
 * sources : programmers
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class BruteForceAlgorithm {

	public static void main(String[] args) {
		System.out.println("BP Algor START...");
		
		int[] answer = {1,2,3,4,5}; 
		
		solution(answer);
	}

	
	public static int[] solution(int[] answers) {
		
		int[] people1 = {1,2,3,4,5};
		int[] people2 = {2,1,2,3,2,4,2,5};
		int[] people3 = {3,3,1,1,2,2,4,4,5,5};
		
		int pl1 = 0, pl2 = 0, pl3 = 0;
		
		for(int i=0; i<answers.length; i++) {
			if( people1[i%(people1.length)] == answers[i] ) {
//				System.out.println("i = " +i+"\t answer : " + answers[i] + "\t" + "1people : " + people1[i%(people1.length)]);
				pl1++;
			}
			if( people2[i%(people2.length)] == answers[i]) {
//				System.out.println("i = " +i+"\t answer : " + answers[i] + "\t" + "2people : " + people2[i%(people2.length)]);
				pl2++;
			}
			if( people3[i%(people3.length)] == answers[i]) {
//				System.out.println("i = " +i+"\t answer : " + answers[i] + "\t" + "3people : " + people3[i%(people3.length)]);
				pl3++;
			}
		}

		System.out.println("pl1 = " + pl1);
		System.out.println("pl2 = " + pl2);
		System.out.println("pl3 = " + pl3);
		
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("1", pl1);
		hm.put("2", pl2);
		hm.put("3", pl3);
		
		// 최대값 구하
		int max = pl1;
		if( max < pl2 ) {
			max = pl2;
		} 
		if( max < pl3 ) {
			max = pl3;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		if( max == hm.get("1") ) {
			list.add(1);
		}
		if( max == hm.get("2")) {
			list.add(2);
		}
		if( max == hm.get("3")) {
			list.add(3);
		}

		int[] ans = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
    }
}