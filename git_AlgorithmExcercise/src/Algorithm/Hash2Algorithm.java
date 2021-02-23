package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Hash 알고리즘
 * @author dongki
 * sources : programmers
 * date : 2021-02-18 (Thur)


각 옷 종류 하나당 다른 옷 종류 하나를 입을 수도 잇음
3종류 : 바지 + 티 + 안경
2종류 : 바지 + 티, 바지 + 안경, 티 + 안경
모두 따로 생각해줘야 함
 */
public class Hash2Algorithm {

	public static void main(String[] args) {

		System.out.println("Hash Start");
		
		String[][] clothes = {{"yellow_hat", "headgear"}
							, {"green_turban", "headgear"}
							
							, {"blue_sunglasses", "eyewear"}
							, {"white_sunglasses", "eyewear"}
							, {"yellow_sunglasses", "eyewear"}
							
							, {"blue_jeans", "pants"}
							, {"grey_jeans", "pants"}
							, {"cream_jeans", "pants"}
							, {"pink_jeans", "pants"}

							, {"a", "gear"}
							, {"b", "gear"}
							, {"c", "gear"}
							, {"d", "gear"}
							, {"e", "gear"}
		};
		
		System.out.println("resutl = "+hash2Solution(clothes));
	}

	//모든 경우의 수를 구하는 걸 생각 못햇음...
	public static int hash2Solution(String[][] clothes) {
		
		int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        System.out.println(map);
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
        	System.out.println(answer);
        	int tmp = it.next().intValue();
        	System.out.println("tmp " + tmp);
            answer *= tmp+1;
        }
        return answer-1;
	}
}
