package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class GreedyJoyStick {

	public static void main(String[] args) {
		String name = "namestring";
		System.out.println(name.charAt(0));
		System.out.println();
		System.out.println(GreedyJoyStickSolution("JEROEN"));
		System.out.println(GreedyJoyStickSolution("JAN"));
		System.out.println(GreedyJoyStickSolution("AAADAAAAAAZJ"));
		System.out.println(GreedyJoyStickSolution("ABABAAAAAAABA"));
		System.out.println(GreedyJoyStickSolution("BAAAAABBB"));
	}
	
	public static int GreedyJoyStickSolution(String name) {
        
        //이름 길이
        char[] chList = name.toCharArray();
        int listLength = chList.length; 
        
        char chA = 'A'; // 65
        char chZ = 'Z'; //90
        
        int joyStickCnt = 0;
        int tailPointer = 0;
        int pointer = 0;

        List<Integer> notAList = new ArrayList<Integer>();
        
        for(int i=0; i<listLength; i++) {
        	if(chList[i] > chA) {
        		notAList.add(i);
        	}
        }
        System.out.println(notAList);
        
        int distance = 0;
        boolean maxFlag = false;

        for(int i=0; i<notAList.size(); i++) {
        	System.out.print("i = " + i);
        	System.out.print("  " + notAList);
        	System.out.print(" joyStickCnt " + joyStickCnt + "   pointer = " + pointer);
        	System.out.print("  notAList.get(i) = " + notAList.get(i) + "  notAList.get(max) = " + notAList.get(notAList.size()-1));
        	//pointer에서 가는 거리 계산
        	if( notAList.get(i) > pointer) {
        		if( notAList.get(i) - pointer > listLength-1-notAList.get(i)+pointer+1) {
        			distance = listLength-1-notAList.get(i)+pointer+1;
        		} else {
        			distance = notAList.get(i)-pointer;
        		}
        	} else {
        		if( pointer - notAList.get(i) > notAList.get(i) + listLength-1-pointer+1) {
        			distance = notAList.get(i) + listLength-1-pointer+1;
        		} else {
        			distance = pointer - notAList.get(i);
        		}
        	}
        	if( notAList.get(notAList.size()-1) > pointer) {
        		if( notAList.get(notAList.size()-1) - pointer > listLength-1-notAList.get(notAList.size()-1)+pointer+1) {
        			if( distance > listLength-1-notAList.get(notAList.size()-1)+pointer+1) {
        				maxFlag = true;
        				distance = listLength-1-notAList.get(notAList.size()-1)+pointer+1;
        			}
        		} else {
        			if( distance > notAList.get(notAList.size()-1)-pointer) {
        				maxFlag = true;
        				distance = notAList.get(notAList.size()-1)-pointer;
        			}
        		}
        	} else {
        		if( pointer - notAList.get(notAList.size()-1) > notAList.get(notAList.size()-1) + listLength-1-pointer+1) {
        			if( distance > notAList.get(notAList.size()-1) + listLength-1-pointer+1) {
        				maxFlag = true;
        				distance = notAList.get(notAList.size()-1) + listLength-1-pointer+1;
        			}
        		} else {
        			if( distance > pointer - notAList.get(notAList.size()-1)) {
        				maxFlag = true;
        				distance = pointer - notAList.get(notAList.size()-1);
        			}
        		}
        	}
        	int tmp = 0;
        	
        	if(maxFlag) {
        		pointer = notAList.get(notAList.size()-1);
        		tmp = notAList.get(notAList.size()-1);
        		notAList.remove(notAList.size()-1);
        	}else {
        		pointer = notAList.get(i);
        		tmp = notAList.get(i);
        		notAList.remove(i);
        	}
        	joyStickCnt = joyStickCnt + distance;
        	
        	System.out.print("   tmp = " + tmp);
        	i = -1;
        	
        	
        	//알파벳 카운트 계산
        	if( (chList[tmp] - chA) > (chZ - chList[tmp]+1) ) {
        		System.out.print("   Z to "+(chZ - chList[tmp]+1));
        		joyStickCnt = joyStickCnt + (chZ - chList[tmp]+1);
        	} else {
        		System.out.print("   A to "+ (chList[tmp]-chA));
        		joyStickCnt = joyStickCnt + (chList[tmp]-chA);
        	}
        	System.out.println();
        }
        
        return joyStickCnt;
    }

}