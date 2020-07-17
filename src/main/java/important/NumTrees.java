package important;

import org.junit.jupiter.api.Test;

public class NumTrees {
    @Test
    public void test() {
        int numTrees = numTrees1(3);
        System.out.println(numTrees);
    }

    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (numTrees(n - i) * numTrees(i - 1));
        }
        return sum;
    }

    public int numTrees1(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
