package important;

import java.util.Arrays;

public class QuckSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 4, 7, 9, 3, 4, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int p = array[i]; // 随机选择 并记录index
        while (i < j) {
            while (p <= array[j] && i < j) {
                j--;
            }
            if (p > array[j]) {
                array[i] = array[j];
                i++;
            }

            while (array[i] <= p && i < j) {
                i++;
            }
            if (array[i] > p) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = p;
        quickSort(array, left, i - 1);
        quickSort(array, j + 1, right);
    }

}
