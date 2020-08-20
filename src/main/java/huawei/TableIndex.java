package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Administrator on 2020/8/20.
 */
public class TableIndex {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = Integer.parseInt(s);
        Map<Integer, Integer> keyMap = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            String keyValue = scanner.nextLine();
            String[] split = keyValue.split(" ");
            int key = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            int oldValue = keyMap.getOrDefault(key, 0);
            keyMap.put(key, value + oldValue);
        }

        for (Map.Entry<Integer, Integer> entry : keyMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
