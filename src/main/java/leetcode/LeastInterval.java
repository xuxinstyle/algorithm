package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastInterval {
    public static void main(String[] args) {
        //char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        char[] tasks = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'};


        int n = 2;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        List<Character> list = new ArrayList<>(tasks.length);
        for (int i = 0; i < tasks.length; i++) {
            list.add(tasks[i]);
            int count = charCountMap.getOrDefault(tasks[i], 0);
            charCountMap.put(tasks[i], count + 1);
        }


        Map<Character, Integer> charCdMap = new HashMap<>();
        int currTime = 0;
        int currPosition = 0;
        while (list.size() > 0) {
            if (currPosition >= list.size()) {
                System.out.println("错误 当前位置[" + currPosition + "]大于size[" + list.size() + "]");
                return -1;
            }
            Character character = list.get(currPosition);
            int cdTime = charCdMap.getOrDefault(character, 0);
            if (cdTime > currTime) {
                //System.out.println("字母["+list.get(currPosition)+"]"+"当前位置["+currPosition+"] 处于cd中cdTime["+cdTime+"]");
                currPosition++;
                if (currPosition >= list.size()) {
                    currTime++;
                    currPosition = 0;
                    System.out.println("全部都在cd中，空跑！！");
                }
                continue;
            }
            // 加cd
            charCdMap.put(character, currTime + n + 1);
            currTime++;
            System.out.println("执行字母[" + list.get(currPosition) + "]" + "当前位置[" + currPosition + "] 当前时间[" + currTime + "]");
            list.remove(currPosition);
            currPosition = 0;

        }

        return currTime;
    }
}
