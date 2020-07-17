package important;

import org.junit.jupiter.api.Test;

public class MaxProfit {
    @Test
    public void testMaxProfit() {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int num0 = Math.max(f2 - prices[i], f0);
            int num1 = f0 + prices[i];
            int num2 = Math.max(f1, f2);
            f0 = num0;
            f1 = num1;
            f2 = num2;
        }
        return Math.max(f1, f2);
    }
}
