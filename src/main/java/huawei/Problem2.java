package huawei;


import java.util.*;

/**
 * @Author：xuxin
 * @Date: 2020/8/20 17:57
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");

        StringBuffer strBuf = new StringBuffer();
        List<String> strList = new ArrayList<>();
        for (String numStr : split) {
            strList.add(numStr);
        }
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareTo(o2, o1);
            }
        });
        for (String string : strList) {
            System.out.print(string);
        }

    }

    public static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);
        char v1[] = str1.toCharArray();
        char v2[] = str2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        int max = Math.max(len1, len2);
        if (k < max) {
            if (len1 > len2 && len2 > 0) {
                return v2[0] - v1[k];
            } else if (len2 > len1 && len1 > 0) {
                return v1[0] - v2[k];
            }
        }
        return len1 - len2;
    }
}
