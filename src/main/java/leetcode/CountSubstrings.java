package leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * <p>
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstrings {

    public static void main(String[] args) {
        String str = "aaa";
        int count = countSubstrings(str);
        System.out.println(count);
    }

    // 暴力穷尽
    // 方法1：以回文序列长度为基准计算数量
    // 方法2：以符号索引为基准计算数量，列出所有以当前字符为最左字符的回文序列
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            count += leftChatCount(s, i);
        }
        return count;
    }

    private static int leftChatCount(String s, int index) {
        int currentCount = 0;
        for (int i = index; i <= s.length() - 1; i++) {
            if (checkSub(s, index, i)) {
                currentCount++;
            }
        }
        return currentCount;
    }

    /**
     * 检查以left和right为边界的字符串是否是回文序列
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static boolean checkSub(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        if (left == right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right) && right - left == 1) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return checkSub(s, left + 1, right - 1);
        }
        return false;
    }

}
