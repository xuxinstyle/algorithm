package huawei;

import java.util.Scanner;

/**
 * Created by Administrator on 2020/8/19.
 */
public class IpCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] result = new int[7];
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split("~");

            if (checkA(split[0])) {
                result[0]++;
            }
        }

    }

    private static boolean checkA(String s) {
        return false;
    }
}
