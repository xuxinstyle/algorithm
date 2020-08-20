package huawei;

import java.util.Scanner;

/**
 * Created by Administrator on 2020/8/19.
 */
public class MayInteger {
    public static void main(String[] args) {
        reviveNum2();
    }

    private static void reviveNum2() {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        StringBuffer sb = new StringBuffer();
        while (v != 0) {
            sb.append(v % 10);
            v = v / 10;
        }
        System.out.println(sb.toString());
    }

    private static void reviveNum1() {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        String str = "" + v;
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);

        }
        System.out.println(sb.toString());
    }

}
