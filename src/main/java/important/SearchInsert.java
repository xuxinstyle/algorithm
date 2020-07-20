package important;

import org.junit.jupiter.api.Test;

public class SearchInsert {
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
