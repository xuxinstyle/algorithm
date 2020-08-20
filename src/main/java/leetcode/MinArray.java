package leetcode;

/**
 * Created by Administrator on 2020/7/22.
 */
public class MinArray {

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 0, 1};
        System.out.println(minArray1(array));
    }

    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int minArray1(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
            if (numbers[left] < numbers[mid]) {
                left = mid;
                continue;
            } else if (numbers[left] > numbers[mid]) {
                right = mid;
            } else {
                left++;
            }

        }
        return numbers[left];
    }
}
