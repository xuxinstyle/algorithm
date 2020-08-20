package huawei;

import java.util.Scanner;

/**
 * Created by Administrator on 2020/8/19.
 */
public class LastStrLenth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                length = chars.length - 1 - i;
                break;
            }
        }
        System.out.println(length);
    }
}
