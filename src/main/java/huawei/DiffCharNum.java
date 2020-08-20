package huawei;

import java.util.Scanner;


/**
 * Created by Administrator on 2020/8/19.
 */
public class DiffCharNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        byte[] bytes = new byte[128];
        byte num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (bytes[chars[i]] == 0) {
                num++;
                bytes[chars[i]] = 1;
            }
        }
        System.out.println(num);

    }
}
