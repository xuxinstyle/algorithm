package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646.最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 示例 :
 * <p>
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * <p>
 * 注意：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 * <p>
 * 题解：
 * 只需要对数组的第二个数进行排序后，从第一个数组开始算，即是最长数对链
 */
public class FindLongestChain {


    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1) {
            return pairs.length;
        }
        Arrays.sort(pairs, new Compater());
        int size = 1;
        int p = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > p) {
                size++;
                p = pairs[i][1];
            }
        }
        return size;
    }

    class Compater implements Comparator<int[]> {

        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }
}
