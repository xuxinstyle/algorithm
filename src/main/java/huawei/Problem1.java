package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author：xuxin
 * @Date: 2020/8/20 17:21
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String maxStr = "(0,0)";
        int maxdis = 0;
        List<String> strs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')' && !stack.empty()) {
                int peek = stack.peek();
                if (chars[peek] == '(') {
                    stack.pop();
                    String substring = str.substring(peek, i + 1);
                    String indexs = substring.substring(1, substring.length() - 1);
                    String[] split = indexs.split(",");
                    if (split.length != 2) {
                        continue;
                    }
                    boolean flag = false;
                    for (String index : split) {
                        if (index.charAt(0) == '0') {
                            flag = true;
                            break;
                        }
                        ;
                    }
                    if (flag) {
                        continue;
                    }

                    int x = Integer.parseInt(split[0]);
                    int y = Integer.parseInt(split[1]);
                    if (x <= 0 || x >= 1000 || y <= 0 || y >= 1000) {
                        continue;
                    }
                    int dis = x * x + y * y;
                    if (dis > maxdis) {
                        maxdis = dis;
                        maxStr = substring;
                    }

                }
            }
        }
        System.out.println(maxStr);
    }
}
