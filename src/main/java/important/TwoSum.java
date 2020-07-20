package important;

import org.junit.jupiter.api.Test;

public class TwoSum {
    @Test
    public void test() {
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(numbers, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length && numbers[i] <= target; i++) {
            for (int j = i + 1; j < numbers.length && numbers[i] + numbers[j] <= target; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] result = {0, 0};
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
