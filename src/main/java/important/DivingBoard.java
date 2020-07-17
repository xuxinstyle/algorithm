package important;

public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }

        int[] array = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            array[i] = i * shorter + (k - i) * longer;
        }
        return array;
    }

}
