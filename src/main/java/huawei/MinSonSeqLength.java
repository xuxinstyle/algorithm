package huawei;

/**
 * Created by Administrator on 2020/8/19.
 */
public class MinSonSeqLength {
    public static void main(String[] args) {
        System.out.println(calcGCRatio("GCGCEWA"));

    }

    private static double calcGCRatio(String str) {
        int gcNum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G' || chars[i] == 'C') {
                gcNum++;
            }
        }
        return gcNum * 1.0 / chars.length;
    }
}
