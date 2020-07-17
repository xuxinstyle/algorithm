package important;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public void testCountSmaller() {

    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    sum++;
                }
            }
            list.add(sum);
        }

        return list;
    }
}
