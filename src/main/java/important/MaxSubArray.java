package important;

import org.junit.jupiter.api.Test;

public class MaxSubArray {
    @Test
    public void test() {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray1(array);
        System.out.println(maxSum);
    }

    /**
     * 时间复杂度0（n^2）
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int[] arrMaxSum = new int[nums.length];
        arrMaxSum[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arrMaxSum[i] = Math.max(arrMaxSum[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, arrMaxSum[i]);
        }

        return maxSum;
    }
}
