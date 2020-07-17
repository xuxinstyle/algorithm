package important;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {

    @Test
    public void test() {
        int[][] triangle = {{-7}, {-2, 1}, {-5, -5, 9}, {-4, -5, 4, 4}, {-6, -6, 2, -1, -5}, {3, 7, 8, -3, 7, -9}, {-9, -1, -9, 6, 9, 0, 7}, {-7, 0, -6, -8, 7, 1, -4, 9}, {-3, 2, -6, -9, -7, -6, -9, 4, 0}, {-8, -6, -3, -9, -2, -6, 7, -5, 0, 7}, {-9, -1, -2, 4, -2, 4, 4, -1, 2, -5, 5}, {1, 1, -6, 1, -2, -4, 4, -2, 6, -6, 0, 6}, {-3, -3, -6, -2, -6, -2, 7, -9, -5, -7, -5, 5, 1}};
        List<List<Integer>> trianglist = new ArrayList<>();
        for (int i = 0; i < triangle.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle[i].length; j++) {
                list.add(triangle[i][j]);
            }
            trianglist.add(list);
        }
        int i = minimumTotal2(trianglist);
        System.out.println(i);
    }

    /**
     * 这个会存在局部最小化的问题，需要解决局部最小化的方式，可以使用倒叙栈，但这里就是需要遍历每一个位置，防止使用贪心导致局部最小化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> firstList = triangle.get(0);
        if (firstList.size() <= 0) {
            return 0;
        }
        int p = 0;
        int minSum = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);

            int num2 = list.get(p);
            int num3 = Integer.MAX_VALUE;
            if (p + 1 < list.size()) {
                num3 = list.get(p + 1);
            }
            int minNum = num2;
            if (num3 < num2) {
                p++;
                minNum = num3;
            }
            minSum += minNum;
        }
        return minSum;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] bp = new int[2][size];
        bp[0][0] = triangle.get(0).get(0);
        int currIndex = 0;
        for (int i = 1; i < size; i++) {
            int preIndex = currIndex;
            currIndex = 1 - currIndex;
            bp[currIndex][0] = bp[preIndex][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                bp[currIndex][j] = Math.min(bp[preIndex][j], bp[preIndex][j - 1]) + triangle.get(i).get(j);
            }
            bp[currIndex][i] = bp[preIndex][i - 1] + triangle.get(i).get(i);
        }

        int minSum = bp[currIndex][0];
        for (int i = 0; i < size; i++) {
            minSum = Math.min(bp[currIndex][i], minSum);
        }
        return minSum;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] bp = new int[size];
        bp[0] = triangle.get(0).get(0);
        int currIndex = 0;
        for (int i = 1; i < size; i++) {
            bp[i] = bp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                bp[j] = Math.min(bp[j], bp[j - 1]) + triangle.get(i).get(j);
            }
            bp[0] = bp[0] + triangle.get(i).get(0);
        }

        int minSum = bp[0];
        for (int i = 0; i < size; i++) {
            minSum = Math.min(bp[i], minSum);
        }
        return minSum;
    }
}
